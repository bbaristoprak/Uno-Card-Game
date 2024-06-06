package loginSignup;

public class User {
	private String nickname;
	private String password;
	private int winCount;
	private int loseCount;
	private int gamesPlayed;
	private int totalScore;
	
	/**
	 * User constructor, this class contains the basic setters and getters.
	 * @param nickname
	 * @param password
	 */
	public User(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}
	
	public String getNickname() {	
		return this.nickname;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void increaseWinCount() {
		this.winCount++;
	}
	
	public void increaseLoseCount() {
		this.loseCount++;
	}
	
	public int getWinCount() {
		return this.winCount;
	}
	
	public int getLoseCount() {
		return this.loseCount;
	}
	
	public void increaseGamesPlayed() {
		this.gamesPlayed++;
	}
	
	public int getGamesPlayed() {
		return this.gamesPlayed;
	}
	
	public void increaseTotalScoreBy(int score) {
		this.totalScore = this.totalScore + score;
	}
	
	public int getTotalscore() {
		return this.totalScore;
	}
}
