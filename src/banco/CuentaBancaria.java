package banco;

/**
 * Clase que impelmenta una cuenta bancaria
 * 
 * @author Adrián
 */
public class CuentaBancaria
{
        /** Nombre del titular de la cuenta */
	private String nombreTitular;
	
        /** Código de la cuenta del cliente */
        private String codigoCuentaCliente;
        
        /** Saldo de la cuenta del cliente  */
	private double saldo;
	
        /**
         * Contructor de la clase CuentaBancaria que otorga un valor por 
         * defecto a los atributos
         */
	public CuentaBancaria ()
	{
		nombreTitular = "";
		codigoCuentaCliente = "";
		saldo = 0.0;
	}

        /**
         * Constructor de la clase CuentaBancaria
         * 
         * @param   nombreTitular       nombre del titular de la cuenta   
         * @param   ccc                 código de la cuenta del cliente
         * @param   saldo               saldo de la cuenta del cliente
         */
	public CuentaBancaria (String nombreTitular, String ccc, double saldo)
	{
		this.nombreTitular = nombreTitular;
		this.codigoCuentaCliente = ccc;
		this.saldo = saldo;
	}

	/**
         * Función que se le pasa un valor y se lo asigna al atributo nombreTitular
         * 
         * @param   nombreTitular   nombre del titular de la cuenta
         */
	public void establecerNombreTitular (String nombreTitular)
	{
		this.nombreTitular = nombreTitular;
	}

	/**
         * Función que se le pasa un valor y se lo asigna al atributo codigoCuentaCliente
         * 
         * @param   ccc     código de la cuenta del cliente
         */
	public void establecerCCC (String ccc)
	{
		codigoCuentaCliente = ccc;		
	}

	/**
         * Función que se le pasa un valor y se lo asigna al atributo saldo
         * 
         * @param   saldo   saldo de la cuenta del cliente
         */
	public void establecerSaldo (double saldo)
	{
		this.saldo = saldo;		
	}

	/**
         * Función que devuelve el valor del atributo nombreTitular
         * 
         * @return  nombre del titular de la cuenta 
         */
	public String obtenerNombreTitular ()
	{
		return nombreTitular;
	}

        /**
         * Función que devuelve el valor del atributo codigoCuentaCliente
         * 
         * @return  código de la cuenta del cliente
         */
	public String obtenerCCC ()
	{
		return codigoCuentaCliente;
	}

        /**
         * Función que devuelve el valor del atributo saldo
         * 
         * @return  saldo de la cuenta del cliente
         */
	public double obtenerSaldo ()
	{
		return saldo;
	}

	/**
         * Función que implementa la operación ingresar
         * @param cantidad  cantidad que se le suma al saldo de la cuenta del cliente
         */
	public void ingresar (double cantidad)
	{
		saldo += cantidad;
	}

	/**
         * Función que impementa la operación retirar
         * @param cantidad  cantidad que se le resta al saldo de la cuenta del cliente
         */
	public void retirar (double cantidad)
	{
		saldo -= cantidad;
	}

}

