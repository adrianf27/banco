package banco;

import java.util.Scanner;

/**
 * Clase que implementa el menú principal de un banco
 * 
 * @author Adrián
 */
public class Banco
{
	/**
         * Función que sale por pantalla 25 saltos de lineas
         */
	public static void borrarPantalla ()
	{
		for (int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}

	/**
         * Función que muestra por pantalla un mensaje en el que tienes que 
         * pulsar la tecla INTRO para continuar mostrando la infomación
         */
	public static void pausar ()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Pulse <INTRO> para continuar...");
		teclado.nextLine();
	}
	
	/**
         * Función que implementa un menú con las diferentes opciones que se 
         * pueden relizar con una cuenta bancaria
         * @return  opción selecionada
         */
	public static int mostrarMenu ()
	{
		Scanner teclado = new Scanner(System.in);
		int opcion;
		
		do
		{
			borrarPantalla();
			System.out.println("MENÚ PRINCIPAL");
			System.out.println("==============");
			System.out.println();
			System.out.println("1) Ver número de cuenta completo (CCC - Código Cuenta Cliente)");
			System.out.println("2) Ver titular de la cuenta");
			System.out.println("3) Realizar un ingreso");
			System.out.println("4) Retirar efectivo");
			System.out.println("5) Consultar saldo");
			System.out.println("6) Salir de la aplicación");
			System.out.println();

			try
			{
				System.out.print("Introduzca la opción deseada: ");
				opcion = teclado.nextInt();
			}
			catch (Exception e)
			{
				teclado.next();
				opcion = 0;
			}
		}
		while ((opcion < 1) || (opcion > 6));

		return opcion;
	}

	/**
         * Función principal del programa
         * @param args  argumentos pasados desde línea de comandos
         */
	public static void main (String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		CuentaBancaria cuentaBancaria;
		String nombreTitular, ccc;
		double saldo;
		int opcion;
		double cantidad;
		
		System.out.println("PROGRAMA DE GESTIÓN DE CUENTA BANCARIA");
		System.out.println("======================================");
		System.out.println();
		

		System.out.print("Introduzca el nombre del titular: ");
		nombreTitular = teclado.nextLine();
			
		System.out.print("Introduzca el Código Cuenta Cliente (CCC): ");
		ccc = teclado.nextLine();
		
		System.out.print("Introduzca el saldo inicial (€): ");
		saldo = teclado.nextDouble();
		
		cuentaBancaria = new CuentaBancaria(nombreTitular, ccc, saldo);
		
		do
		{
			opcion = mostrarMenu();
			
			switch (opcion)
			{
				case 1:	
					// mostramos por pantalla el Código Cuenta Cliente (CCC) de la cuenta bancaria
					borrarPantalla();
					System.out.println("Código Cuenta Cliente (CCC): " + cuentaBancaria.obtenerCCC());
					pausar();
					break;

				case 2:
					// mostramos por pantalla el nombre del titular de la cuenta bancaria
					borrarPantalla();
					System.out.println("Titular de la cuenta: " + cuentaBancaria.obtenerNombreTitular());
					pausar();
					break;
													
				case 3:
					// realizamos un ingreso en la cuenta bancaria
					borrarPantalla();
						
					try
					{
						System.out.print("Introduzca la cantidad de dinero a ingresar: ");
						cantidad = teclado.nextDouble();
							
						if (cantidad <= 0)
						{
							throw new Exception();
						}
						else
						{
							cuentaBancaria.ingresar(cantidad);
							System.out.println("[INFO]: ingreso realizado con éxito.");
						}
					}
					catch (Exception e)
					{
						teclado.nextLine();
						System.out.println("[ERROR]: la cantidad indicada no es válida.");
					}
						
					pausar();
					break;
						
				case 4:
					// retiramos dinero de la cuenta bancaria
					borrarPantalla();
						
					try
					{
						System.out.print("Introduzca la cantidad de dinero a retirar: ");
						cantidad = teclado.nextDouble();
							
						if ((cantidad <= 0) || (cantidad > cuentaBancaria.obtenerSaldo()))
						{
							throw new Exception();
						}
						else
						{
							cuentaBancaria.retirar(cantidad);
							System.out.println("[INFO]: retirada de efectivo realizada con éxito.");
						}
					}
					catch (Exception e)
					{
						teclado.nextLine();
						System.out.println("[ERROR]: la cantidad indicada no es válida.");
					}
						
					pausar();
					break;
						
				case 5:
					// mostramos el saldo de la cuenta
					borrarPantalla();
					System.out.printf("Saldo de la cuenta: %.2f €\n", cuentaBancaria.obtenerSaldo());
					
					pausar();
					break;
			}
		}
		while (opcion != 6);
		
	}

}

