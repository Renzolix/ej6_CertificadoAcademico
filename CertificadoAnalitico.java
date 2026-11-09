public class CertificadoAnalitico implements Imprimible, ValidableDigitalmente {
    private String estudiante;
    private boolean firmado;

    public CertificadoAnalitico(String estudiante, boolean firmado) {
        this.estudiante = estudiante;
        this.firmado = firmado;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo Certificado Analítico oficial de: " + estudiante);
    }

    @Override
    public boolean verificarFirmaDigital() {
        return firmado;
    }

    public static void main(String[] args) {
        CertificadoAnalitico certificado = new CertificadoAnalitico("Renzo Gonzalez", true);

        System.out.println("--- Referencia Imprimible ---");
        Imprimible imp = certificado;
        imp.imprimirDocumento();
        // imp.verificarFirmaDigital(); // Error de compilación: no visible en Imprimible

        System.out.println("\n--- Referencia ValidableDigitalmente ---");
        ValidableDigitalmente val = certificado;
        boolean esValido = val.verificarFirmaDigital();
        System.out.println("¿Firma digital válida?: " + (esValido ? "SÍ" : "NO"));
        // val.imprimirDocumento(); // Error de compilación: no visible en ValidableDigitalmente
    }
}