Karatsuba
=========

Aplicaci�n de escritorio para multiplicar dos n�meros con el algoritmo de Karatsuba. 
Proyecto para Eclipse IDE. 
Ejecutable (JAR).

------------------------------------------------------------------------------------
-------------------------------------EJECUCI�N--------------------------------------

Para ejecutar este proyecto como una aplicaci�n debe ejecutarse el archivo .jar
ubicado en la carpeta "ejecutable". Para que el .jar funcione adecuadamente el
sistema debe tener instalado el JDK Java que puede descargarse de la siguiente 
p�gina WEB: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html?ssSourceSiteId=otnes
(Se debe marcar primero la opci�n Accept License Agreement).

Tambi�n puede ejecutarse como proyecto de Eclipse IDE. Para esto se debe descargar
(en adici�n al JDK de Java) el IDE y descomprimirlo en cualquier carpeta:
http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/indigosr2
(las posibles versiones de sistema operativo se encuentran en un p�nel a la derecha).



Una vez inicie la aplicaci�n ver� tres campos de texto. Dos editables (Primer n�mero y Segundo n�mero) 
y uno de s�lo lectura (Resultado). Ingrese en cada uno de los campos los n�meros que desea 
multiplicar y haga clic en el bot�n "Multiplicar". El resultado de la operaci�n se mostrar� 
en pantalla y en caso de haber un error la aplicaci�n se lo mostrar� tambi�n.

Los campos se redimensionar�n para acomodarse al tama�o del n�mero del resultado.

------------------------------------------------------------------------------------
------------------------------------ESTRUCTURA--------------------------------------

El proyecto se basa en el patr�n modelo-vista-controlador:
Todo el c�digo se encuentra dentro de la carpeta "src" organizado en paquetes (carpetas)
+ La clase principal (main) se encuentra en el archivo KaratsubaMain.java dentro de la carpeta "main":
    Esta clase se encarga de iniciar todos los objetos del patr�n y de hacer visible la ventana de la aplicaci�n
+ La clase de la vista se encuentra en el archivo KaratsubaUI.java dentro de la carpeta "interfazgrafica":
    Esta clase organiza los elementos de la ventana principal para mostrarlos al usuario. Entre las tareas
    que lleva acabo est� la distribuci�n de los campos para ingresar datos, la inserci�n del logo de la
    aplicaci�n y la actualizaci�n en pantalla de los valores de los campos y los mensajes de error.
+ La clase del controlador se encuentra en el archivo KaratsubaControlador.java dentro de la carpeta "controlador"
    Esta clase se encarga de controlar los eventos realizados sobre el bot�n que env�a los valores a multiplicar.
    Para ello se usa una clase interna que se asocia como manejador de eventos del bot�n. 
    En esta clase tambi�n se realizan las siguientes validaciones:
       :: Valores no v�lidos (texto, caracteres especiales, signos)
       :: Valores negativos
    Una vez superadas las verificaciones se llamar� al algoritmo de multiplicaci�n y se actualizar�
    el resultado en la pantalla.
+ La clase del modelo (nucleo) se encuentra en el archivo KaratsubaAlgoritmo.java dentro de la carpeta "Karatsuba":
    Esta clase contiene el algoritmo para realizar una multiplicaci�n con el m�todo de Karatsuba 
    (http://en.wikipedia.org/wiki/Karatsuba_algorithm#Algorithm). El resultado se guarda en un atributo que
    es le�do por la vista para mostrarlo en pantalla.
+ Hay dos clases adicionales. Una de constantes (constantes/Constantes.java) donde se encuentran los textos 
  a mostrar en pantalla para errores, etiquetas de campos y t�tulo de la pantalla. Y una que crea un p�nel
  sobre el que se pone la im�gen de logo de la aplicaci�n (interfazgrafica/PanelLogo.java).

------------------------------------------------------------------------------------
------------------------------------------------------------------------------------

Cualquier comentario escribir a: mapedorr@gmail.com

------------------------------------------------------------------------------------
------------------------------------------------------------------------------------