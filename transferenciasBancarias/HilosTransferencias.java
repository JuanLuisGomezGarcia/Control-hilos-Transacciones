
    package transferenciasBancarias;
    public class HilosTransferencias extends Thread {
    //Atributos de la clase que gestiona los hilos de las transacciones
    String idTransacion;
    int cantidad;
    CuentaBanco banco;
    
    //Constructor de la clase
    public HilosTransferencias(CuentaBanco banco,String idTransancion, int transferencia)
    throws InterruptedException{
    this.cantidad = transferencia;
    this.banco = banco;
    this.idTransacion = idTransancion;}
    
    //Funcion run que activa el metodo de la clase cuentaBanco
    public void run(){    
    this.banco.transferencia(cantidad,idTransacion);}}


