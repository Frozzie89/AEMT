package be.helha.groupeB4.enumeration;

public enum EPaeProgress {
	A_FAIRE("A faire"),
	EN_COURS("En cours"),
	TERMINE("Termin�");
	
	private String progress;
	private EPaeProgress(String progres) {
		this.progress=progress;
	}
	
	public String getProgress() {
		return this.progress;
	}
}
