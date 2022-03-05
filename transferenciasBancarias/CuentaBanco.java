
    package transferenciasBancarias;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    public class CuentaBanco {
    // Atributos de la clase
    int cantidaDinero;
    
    //Constructor de la clase
    public CuentaBanco(int cantidadDinero){
    this.cantidaDinero = cantidadDinero;}
    
    //Funcion suncronized esta funcion se encargara de actualizar los fondos de la 
    //cuenta bancaria y controlara que estos fondos nunca esten por debajo de cero.
    synchronized public void transferencia(int cantidad,String idTransancion) {
    
    //Mostramos que proceso estamos procesando
    System.out.println("- PROCESANDO " + idTransancion + "CANTIDAD: " + cantidad);
    
    // Declaramos dos variables fuera del do una es la cuenta bancaria y otro un boolean
    //que nos servira para activar un mensage por pantalla que avisara de que 
    //la transsacion a dejado de estar en espera
    int cuenta = this.cantidaDinero;
    Boolean avisoRetorno=false;
    
    //Abrimos un do while que volvera a repetir el if que evita que la cienta
    //pase a menos cero
    do{
    
    // Estas variables estan dentro del do while para que se actualizen desues del wait
    cuenta = this.cantidaDinero;
    
    //Actualizamos la variable cuenta con la cantidad de la transacion esta variable 
    //nos ayudara como filtro en los diferentes condicionales
    cuenta += cantidad; 
    
    //Este mensage se activa con el boolean declarado antes que se pone en true 
    //una vez pasado el wait
    if(avisoRetorno){ System.out.println(idTransancion + "- YA NO ESTA EN ESPERA");}
    
    //El if central que controla la caracteristica mas importante de la funcion 
    //que es que la cuenta no pase a cero
    if(cuenta < 0){
    
    //El try catch necesario para utilizar la funcion wait junto con su mensage        
    //de aviso de que la transacon esta en espera y la modificacion del boolean
    try {
    System.out.println(idTransancion + "EN ESPERA\n");    
    wait();
    avisoRetorno = true;
    } catch (InterruptedException ex) {
    Logger.getLogger(CuentaBanco.class.getName()).log(Level.SEVERE, null, ex);
    
    //Salida del while si el resultado de la transacion y los fondos es positivo
    }}} while(cuenta < 0); 
    
    // En caso de que el resultado se positivo se realiza la transaccion        
    if(cuenta > 0){       
    this.cantidaDinero+=cantidad;
    System.out.println(idTransancion + " REALIZADA. " + "\nESTADO DE LA CUENTA: " +
    this.cantidaDinero + "\n");
    
    //Y despertamos los hilos pausados
    notify();}}
    
    //Set y get de la clase CuentaBanco
    public void setCantidadDinero(int cantidadDinero){
    this.cantidaDinero = cantidadDinero;}   
    public int getCantidadDinero(){       
    return cantidaDinero;}}
