/**
 * Queremos implementar un xogo en Java que permita ao usuario adiviñar un número oculto (que será aleatorio). O funcionamento será o seguinte:

O programa amosará un pequeno menú en pantalla coas seguintes opcións (1. Configurar, 2. Xogar, 3. Saír).

Se o usuario selecciona a primeira opción, solicitaráselle por teclado o número de intentos permitidos (numInt) e o número máximo (numMax) xerado.

Se o usuario selecciona a opción 2, o programa xerará un número aleatorio entre 0 e numMax, que será o número a adiviñar (numOculto). A partir deste momento, solicitaráselle ao usuario números ata adiviñar o número oculto.

Se o usuario adiviña o número, amosarase unha mensaxe "Gañaches! Necesitaches X intentos".

Se se esgotan os intentos sen adiviñar o número, amosarase a mensaxe "Perdiches! Intentos esgotados".

En cada intento, se o usuario non adiviña o número, proporcionaráselle unha pista, por exemplo, "O número oculto é menor".

En ambos casos, a seguinte acción será amosar o menú de novo.

Se o usuario selecciona "Xogar" sen configurar previamente o número de intentos e o número máximo xerado, tomarase como valores por defecto: numInt=5 e numMax=10.

Se o usuario preme a opción 3, o programa finalizará.

Para xerar un número aleatorio en Java podes utilizar o seguinte código:

 
int numOculto = (int)Math.floor(Math.random()*20+1); // xera un número aleatorio entre 0 e 20, ambos incluídos.
 *
 */


/**  Chegados a exercicios que empezan a ter certo grao de complexidade é mellor empezar
 *   a empregar Orientación a Obxectos.
 *   Imos ver como quedaría este exerccico con OOP:
 *
 *   	Dispoñemos dunha clase XogoAdivinha que define obxectos (obxectos XogoAdiviña) que teñen as seguintes características:
 *   		Un número máximo a sortear
 *   		Un número de intentos para adiviñar
 *
 *   	Esta clase ten as seguintes funcionalidades:
 *   		xogar - Xoga unha partida
 *   		configurar - Permite variar os atributos dos obxectos.
 *
 *   	Con esta idea, o programa principal quedaría así:
 *
 *   		Definimos a clase Input, que permite a entrada de información. So precisamos que nos permita introducir un número enteiro
 *   		entre 0 e o valor que lle indiquemos.
 *
 *   		O programa (Adivinha) fará uso dun obxecto XogoAdiviha para acadar a funcionalidade requirida.
 *   		
 */
import java.util.concurrent.CancellationException;


public class Adivinha {
	// Mellor que traballar con 1, 2, e 3 sería mellor facelo con constantes. E mais claro e mantible.
	static final int CONFIGURAR=1;
	static final int XOGAR=2;
	static final int SAIR=3;

	// Debemos presentar un menú con tres opcións. A 1 permite configurar, a 2 permite xogar e a 3 sair.
	// Iso quere decir que o usuario debe poder elexir entre esas 3 opcións as veces que desexe...
	// salvo que elixa saír, que rematará o programa..
	//
	// Aplicamos deseño descendente. Non me preocupa agora en qué consiste configurar, nin 
	// xogar. So me preocupa que o programa faga o que se pide.
	//
	public static void main(String[] args) {
		int opc=0;
		// Non podemos permitir que o programa rompa por unha entrada errónea...
		// repetimos mentres non elixamos sair. Como mínimo queremos que o menú
		// salga unha vez (se pode facer con while, en lugar de do...while axustando
		// previamente o valor de opc
		XogoAdivinha xogo=new XogoAdivinha(20,5);	// Creamos un XogoAdiviña, con parámetros iniciais de 5 intentos e número entre 0 e 20
		try {
	  	   do {
			// Visualizamos o menú
			System.out.println(" Menú do Xogo ");
			System.out.println("--------------");
			System.out.println("1.- Configurar");
			System.out.println("2.- Xogar");
			System.out.println("3,- Sair");
			// Pedimos a opción
			System.out.print("\nElixe Opcion: ");
			opc=Input.getInt("Introduce Opcion",1,3);
			// Realizamos a acción seleccionada
			switch(opc) {	// Se pode facer con "if... else"
				case CONFIGURAR: configurar(xogo); break;
				case XOGAR: xogar(xogo); break;
				case SAIR: break; //  é sair, pero si é 3, o programa xa sae...
			}
		   } while(opc!=3);
		} catch(CancellationException e) {
			System.out.println("Operación cancelada");
		}
	}

	// Debemo ir pedindo números ata que acerte ou agote os intentos, visualizando
	// ao final o numero de intentos usados.
	public static void xogar(XogoAdivinha xogo) {
		int result,num;
		xogo.start();
		try {
			do {
				num=Input.getInt("Introduce un número entre 0 e "+xogo.getMaxNumero(),0,xogo.getMaxNumero());
				result=xogo.xogar(num);
				if (result<0) System.out.println("Maior");
				else if (result>0) System.out.println("Menor");
			} while(result!=0);
			System.out.println("Acertaches en "+xogo.getIntentos()+" intentos");
		} catch(CancellationException e) {
			System.out.println("Xogo Cancelado");
		} catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

	/**  Debemos configurar: Os intentos permitidos (numInt) e u número máximo a xerar (numMax)
	 *
	 */
	public static void configurar(XogoAdivinha xogo) {
		// Si defino aquí numInt e numMax, serán variables locais a este método, desaparecerán
		// cando a execución do método remate, e non terán efecto. Necesitamos que sexan variables
		// da clase (xa que non estamos a utilizar obxectos)
		// Si querermos visualizar o estadoo modificado.....
		
		try {
			showConfig(xogo);
			int nmax=Input.getInt("Numero Maximo",0,Integer.MAX_VALUE);
			int nint=Input.getInt("Numero Intentos",1,30);
			xogo.configurar(nmax,nint);
			showConfig(xogo);
		} catch(CancellationException e) {
			System.out.println("Configuración cancelada");
		}
	}

	private static void showConfig(XogoAdivinha xogo) {
			System.out.println("A configuración actual é: ");
			System.out.println("Numero entre 0 e "+xogo.getMaxNumero());
			System.out.println(xogo.getMaxIntentos()+" intentos como máximo");
			System.out.println();
	}
}

