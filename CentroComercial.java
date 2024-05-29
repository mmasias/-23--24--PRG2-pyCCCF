clase  CentroComercial {
     caja privada [] cajas ;
     Cliente privado [] cola ;
    privado  int  último ;
    privado  int  minutosSinCola ;
     CentroComercial público (){
        cajas = nueva  Caja [ 4 ];
        for ( int  i = 0 ; i < cajas . longitud ; i ++) {
            cajas [ i ] = nueva  Caja ( i );
        }
        cola = nuevo  Cliente [ 100 ];
        ultimo = 0 ;
        minutosSinCola = 0 ;
    }
    public  void  recibe ( Cliente  cliente ) {
        cola [ último ] = cliente ;
        último ++;
    }
    public  void  actualizar () {
        si ( último > 0 ) {
            deColaACaja ();
        }
        atiendeCajas ();
    }

    vacío privado deColaACaja() {
        for ( int  i = 0 ; i < cajas . longitud ; i ++){
        for(int i=0;i<cajas.length;i++ && ultimo>0 ){
            if ( cajas [ i ]. estaLibre ()){
                Cliente  cliente = cola [ ultimo - 1 ];
                del mes pasado--;
                cajas [ i ]. recibe ( cliente );

            }
            si (ultimo==0) {
                minutosSinCola ++;
                romper;
            }
        }
    }

     void  privado atiendeCajas () {
        for ( int  i = 0 ; i < cajas . longitud ; i ++) {
            cajas [ i ]. atiende ();
        }
    }
    public  void  verEstado ( int  minutoActual ) {
        Sistema . afuera . println ( "Minuto actual: " + minutoActual );
        Sistema . afuera . println ( ultimo + "personas en cola" );
        for ( int  i = 0 ; i < cajas . longitud ; i ++) {
            cajas [ i ]. verEstado ();
        }
    }
    public  void  mostrarEstadisticasJornada () {
        int  personasAtendidasTotal = 0 ;
        for ( int  i = 0 ; i < cajas . longitud ; i ++) {
            personasAtendidasTotal = personasAtendidasTotal + cajas [ i ]. obtenerPersonasAtendidas ();
        }
        int  articulosTotalesVendidos = 0 ;
        for ( int  i = 0 ; i < cajas . longitud ; i ++) {
            articulosTotalesVendidos = articulosTotalesVendidos + cajas [ i ]. obtenerArticulosVendidos ();
        }
        Sistema . afuera . println ( "RESUMEN" );
        Sistema . afuera . println ( "=" . repetir ( 60 ));
        Sistema . afuera . println ( "Minutos con cola en cero: " + minutosSinCola );
        Sistema . afuera . println ( "Personas en la cola al cierre: " + ultimo );
        Sistema . afuera . println ( "Personas atendidas en el dia: " + personasAtendidasTotal );
        Sistema . afuera . println ( "Articulos vendidos en el dia: " + articulosTotalesVendidos );
        Sistema . afuera . println ( "=" . repetir ( 60 ));
        
    }
}
