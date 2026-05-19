package Milestone3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Factory {

	private static MatchSummary readMatch(String line) {
	    try {
	        String[] info = line.split(",");

	        if (info.length != 5)
	            throw new IllegalArgumentException("Invalid CSV line: " + line);

	        Integer matchId = Integer.parseInt(info[0].trim());
	        String botType = info[1].trim();
	        String result = info[2].trim();
	        Double timeMs = Double.parseDouble(info[3].trim());
	        Integer totalClicks = Integer.parseInt(info[4].trim());

	        return new MatchSummary(matchId, botType, result, timeMs, totalClicks);

	    } catch (Exception e) {
	        System.out.println("Problematic line: " + line);
	        throw e;
	    }
	}
	
	public static MatchDataset readMatches(String fileName) {
		MatchDataset m = null;

		try {
			Stream<MatchSummary> ms = Files.lines(Paths.get(fileName))
					.skip(1)
					.map(Factory::readMatch);
			m = new MatchDataset(ms);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return m;
	}
}
