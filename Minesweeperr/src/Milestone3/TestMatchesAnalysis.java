package Milestone3;

public class TestMatchesAnalysis {
	public static void main(String[] args) {
		MatchDataset dataset = Factory.readMatches("src/matches.csv");
		System.out.println("Total amount of parsed matches: " + dataset.getMatches().size());
		System.out.println("Average clicks for VICTORY:     " + dataset.getAverageClicksByResult("VICTORY"));
		System.out.println("Average clicks for DEFEAT:      " + dataset.getAverageClicksByResult("DEFEAT"));
		System.out.println("The Match with the highest Clickrate is: " + dataset.getMatchWithHighestClickRate());	
	}
}
