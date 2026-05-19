package Milestone3;

public class MatchSummary implements Comparable<MatchSummary>{

	private Integer matchId; // change to int in case does not work
	private String botType;
	private String result;
	private Double timeMs;
	private Integer totalClicks; //change to int in case does not work
	
	
	public MatchSummary(Integer matchId, String bT, String r, Double tMs, Integer tClk) {
		this.matchId = matchId;
		this.botType = bT;
		this.result = r;
		this.timeMs = tMs;
		this.totalClicks = tClk;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public String getBotType() {
		return botType;
	}

	public String getResult() {
		return result;
	}

	public Double getTimeMs() {
		return timeMs;
	}

	public Integer getTotalClicks() {
		return totalClicks;
	}
	
	public int compareTo(MatchSummary mS) {
		return this.timeMs.compareTo(mS.getTimeMs());
	}

	public Double getClickRate() {
		Double ans = (double) totalClicks;
		if (timeMs != 0)
			ans = ans/(double) timeMs;
		return ans;
	}
	
	@Override
	public String toString() {
	    return "MatchSummary{" +
	            "matchId=" + matchId +
	            ", botType='" + botType + '\'' +
	            ", result='" + result + '\'' +
	            ", timeMs=" + timeMs +
	            ", totalClicks=" + totalClicks +
	            '}';
	}
}
