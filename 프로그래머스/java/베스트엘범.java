package 프로그래머스.java;
import java.util.*;

public class 베스트엘범 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> anwList = new ArrayList<>();
            Map<String, Integer> genTotCnt = getGenTotCnt(genres, plays);
            List<String> sortNameList = getSortGenList(genTotCnt);
            Map<String, int[]> genCntArr = getGenCnt(genres, plays, sortNameList);

            for(int i = sortNameList.size()-1; i >= 0; i--){
                for(int j : genCntArr.get(sortNameList.get(i))){
                    anwList.add(j);
                }
            }
            int[] answer = new int[anwList.size()];
            for(int i = 0; i < anwList.size(); i++){
                int time = anwList.get(i);
                for(int j = 0; j < plays.length; j++){
                    if(time == plays[j]){
                        answer[i] = j;
                        plays[j] = 0;
                        break;
                    }
                }
            }

            return answer;
        }
        private List<String> getSortGenList(Map<String, Integer> genTotCnt){
            List<String> rtnList = new ArrayList<>();
            List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genTotCnt.entrySet());
            entryList.sort(((o1, o2) -> genTotCnt.get(o1.getKey()) - genTotCnt.get(o2.getKey())));
            for(Map.Entry<String, Integer> entry : entryList){
                rtnList.add(entry.getKey());
            }
            return rtnList;
        }

        // 장르별 재생 총 횟수
        private Map<String, Integer> getGenTotCnt(String[] genres, int[] plays){
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < genres.length; i++){
                map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            }
            return map;
        }

        // 장르마다의 각각의 재생 횟수, 정렬 후
        private Map<String, int[]> getGenCnt(String[] genres, int[] plays, List<String> genNameList){
            Map<String, int[]> map = new HashMap<>();
            for(int i = 0; i < genNameList.size(); i++){
                String genre = genNameList.get(i);
                List<Integer> cntList = new ArrayList<>();
                for(int j = 0; j < genres.length; j++){
                    if(genre.equals(genres[j])) cntList.add(plays[j]);
                }
                Collections.sort(cntList, Collections.reverseOrder());
                if(cntList.size() == 1) map.put(genre, new int[]{cntList.get(0)});
                else map.put(genre, new int[]{cntList.get(0), cntList.get(1)});
            }

            return map;
        }
    }
}

/** 참고할 코드 */
/*import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        PlayHistories playHistories = PlayHistoriesFactory.create(genres, plays);

        return playHistories.getBestAlbum().stream()
                .map(PlayHistory::getSongId)
                .mapToInt(Long::intValue)
                .toArray();
    }

    public static class PlayHistoriesFactory {
        public static PlayHistories create(String[] genres, int[] plays) {
            Map<String, List<PlayHistory>> playHistories = new HashMap<>();

            for (int id = 0, length = genres.length; id < length; id++) {
                List<PlayHistory> histories = playHistories.getOrDefault(genres[id], new ArrayList<>());
                histories.add(PlayHistory.of(id, plays[id]));
                playHistories.put(genres[id], histories);
            }

            return new PlayHistories(playHistories);
        }
    }

    public static class PlayHistories {
        private final List<PlayHistoriesByGenre> playHistories;

        public PlayHistories(List<PlayHistoriesByGenre> playHistories) {
            this.playHistories = playHistories;
        }

        public PlayHistories(Map<String, List<PlayHistory>> playHistories) {
            this.playHistories = playHistories.entrySet().stream()
                    .map(entry -> new PlayHistoriesByGenre(entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
        }

        public List<PlayHistory> getBestAlbum() {
            return this.playHistories.stream()
                    .sorted(Comparator.reverseOrder())
                    .map(PlayHistoriesByGenre::getBestTwoSongs)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
    }

    public static class PlayHistoriesByGenre implements Comparable<PlayHistoriesByGenre> {
        private final List<PlayHistory> playHistories;
        private final String genre;

        public PlayHistoriesByGenre(String genre, List<PlayHistory> playHistories) {
            this.playHistories = playHistories;
            this.genre = genre;
        }

        public List<PlayHistory> getBestTwoSongs() {
            return this.playHistories.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(2)
                    .collect(Collectors.toList());
        }

        public Integer calculatePlayTimes() {
            return this.playHistories.stream()
                    .map(PlayHistory::getPlayTimes)
                    .reduce(0, Integer::sum);
        }

        @Override
        public int compareTo(PlayHistoriesByGenre other) {
            return this.calculatePlayTimes().compareTo(other.calculatePlayTimes());
        }
    }

    public static class PlayHistory implements Comparable<PlayHistory> {
        private final Song song;
        private final Integer playTimes;

        public PlayHistory(Song song, Integer playTimes) {
            this.song = song;
            this.playTimes = playTimes;
        }

        public static PlayHistory of(Integer songId, Integer playTimes) {
            return of(Long.valueOf(songId), playTimes);
        }

        public static PlayHistory of(Long songId, Integer playTimes) {
            return new PlayHistory(new Song(songId), playTimes);
        }

        public Long getSongId() {
            return song.getId();
        }

        public Integer getPlayTimes() {
            return playTimes;
        }

        @Override
        public int compareTo(PlayHistory other) {
            return this.playTimes.compareTo(other.playTimes);
        }
    }

    public static class Song {
        private final Long id;

        public Song(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }
}*/
