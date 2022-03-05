
    package transferenciasBancarias;
    public class Transferencias {
    public static void main(String[] args) throws InterruptedException {
    //Creacion del objeto de la cuenta banco
    CuentaBanco cuentaUno = new CuentaBanco(5000);
     
    //Creacio de los hilos que realizaran las transacciones economicas
    HilosTransferencias hiloUno = new HilosTransferencias(cuentaUno,"Transancion 1 ",-4000);
    HilosTransferencias hiloDos = new HilosTransferencias(cuentaUno,"Transancion 2 ",-2000);
    HilosTransferencias hiloTres = new HilosTransferencias(cuentaUno,"Transancion 3 ",5000);
    HilosTransferencias hiloCuatro = new HilosTransferencias(cuentaUno,"Transancion 4 ",6000);
    HilosTransferencias hiloCinco = new HilosTransferencias(cuentaUno,"Transancion 5 ",2000);
    HilosTransferencias hiloSeis = new HilosTransferencias(cuentaUno,"Transancion 6 ",-2000);
    HilosTransferencias hiloSiete = new HilosTransferencias(cuentaUno,"Transancion 7 ",-10000);
    HilosTransferencias hiloOcho = new HilosTransferencias(cuentaUno,"Transancion 8 ",4000);
    HilosTransferencias hiloNueve = new HilosTransferencias(cuentaUno,"Transancion 9 ",-2000);
    HilosTransferencias hiloDiez = new HilosTransferencias(cuentaUno,"Transancion 10 ",-1000);
    
    //Activacion de dichos hilos
    hiloUno.start();
    hiloDos.start();
    hiloTres.start();
    hiloCuatro.start();
    hiloCinco.start();
    hiloSeis.start();
    hiloSiete.start();
    hiloOcho.start();
    hiloNueve.start();
    hiloDiez.start();}}


