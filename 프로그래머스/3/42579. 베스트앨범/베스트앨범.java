import java.util.*;
import java.util.stream.*;

class Solution {
    static class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();
    
    for (int i = 0; i < genres.length; i++) {
        total.merge(genres[i], plays[i], Integer::sum);
        
        songsByGenre 
            .computeIfAbsent(genres[i], g -> new ArrayList<>())
            .add(new Song(i, plays[i]));
    }
    
    List<String> sortedGenres = total.entrySet().stream()
        .sorted((a, b) -> b.getValue() - a.getValue())
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
    
    List<Integer> result = new ArrayList<>();
    
    for(String genre : sortedGenres) {
        List<Song> list = songsByGenre.get(genre);
        
        list.sort((a,b) -> {
            if (b.play != a.play) return b.play - a.play;
            return a.index - b.index;
        });
        
        for (int i = 0; i < Math.min(2, list.size()); i++) {
            result.add(list.get(i).index);
        }
    }
    
    return result.stream().mapToInt(i -> i).toArray();
}   
}

