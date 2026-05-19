package Milestone3;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchDataset {

	private SortedSet<MatchSummary> matches;
	public MatchDataset(Stream<MatchSummary> m) {
		this.matches = m.collect(Collectors.toCollection(TreeSet::new));
	}
	
	public SortedSet<MatchSummary> getMatches() {
		return matches;
	}
	
	public Double getAverageClicksByResult(String result) {
	    Long nMatches = matches.stream()
	            .filter(a -> a.getResult().equals(result))
	            .count();

	    Double ans = 0.0;

	    if (nMatches != 0) {
	        ans = matches.stream()
	                .filter(a -> a.getResult().equals(result))
	                .collect(Collectors.averagingInt(MatchSummary::getTotalClicks));
	    }

	    return ans;
	}
	
	public MatchSummary getMatchWithHighestClickRate() {
		return matches.stream().filter(m -> m.getTimeMs() != 0)
				.max(Comparator.comparingDouble(MatchSummary::getClickRate)).orElseThrow();
	}
	


}
