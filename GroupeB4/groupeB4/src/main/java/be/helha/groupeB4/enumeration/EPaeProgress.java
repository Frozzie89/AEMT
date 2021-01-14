package be.helha.groupeB4.enumeration;

public enum EPaeProgress {
	A_FAIRE("A faire"),
	EN_COURS("En cours"),
	TERMINE("Termine");
	
	private String progress;
	private EPaeProgress(String progres) {
		this.progress=progres;
	}
	
	public String getProgress() {
		return this.progress;
	}
}
