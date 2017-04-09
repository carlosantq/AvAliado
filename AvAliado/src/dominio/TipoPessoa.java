package dominio;

public enum TipoPessoa {
	professor,
	aluno;
	
	public static TipoPessoa fromInteger(int x) {
        switch(x) {
        case 0:
            return professor;
        case 1:
            return aluno;
        }
        return null;
    }
}
