package be.helha.groupeB4.enumeration;

public enum ESection {
	COMPTABILITE("Comptabilité"),
	INFORMATIQUE_DE_GESTION("Informatique de gestion"),
	ASSISTANT_DE_DIRECTION("Assistant de direction");
	
	private String section;
	
	private ESection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return this.section;
	}
}
