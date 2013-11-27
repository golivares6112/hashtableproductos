package cl.business.objetos;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppMain {
	
	private static PrintStream out;
	private static Scanner lector;
	private static char opcion;
	private static String codigoBarra;
	private static String categoria;
	private static String nombre;
	private static int precio;
	private static List<Producto> listaProductos;
	private static Producto producto;
	static
	{
		out = System.out; 
	}
	
	public static void main(String[] args)
	{
		lector = new Scanner(System.in);
		while(opcion!='6')
		{
			menu();
			opcion = lector.next().charAt(0);
			switch (opcion) 
			{
				case '1':
					listaProductos = new ArrayList<Producto>();
					producto = new Producto(); 
					out.println("Ingrese codigo de barra del producto");
					codigoBarra = lector.next();
					out.println("Ingrese categoria del producto");
					categoria = lector.next();
					out.println("Ingrese nombre del producto");
					nombre = lector.next();
					out.println("Ingrese precio del producto");
					precio = lector.nextInt();
					producto.setCodigoBarra(codigoBarra);
					producto.setCategoria(categoria);
					producto.setNombre(nombre);
					producto.setPrecio(precio);
					listaProductos.add(producto);
					HashTableProductos.ingresarProductoLista(categoria, listaProductos, producto);
					out.println(" - Producto Agregado - ");
					break;
				case '2':
					out.println("Ingrese categoria del producto a modificar");
					categoria = lector.next();
					out.println("Ingrese codigo de barra del producto");
					codigoBarra = lector.next();
					if(HashTableProductos.buscarProductoCodigoBarra(categoria, codigoBarra))
					{
						
						producto = new Producto();
						out.println("Ingrese nueva categoria del producto");
						categoria = lector.next();
						out.println("Ingrese nuevo nombre del producto");
						nombre = lector.next();
						out.println("Ingrese nuevo precio del producto");
						precio = lector.nextInt();
						producto.setCodigoBarra(codigoBarra);
						producto.setCategoria(categoria);
						producto.setNombre(nombre);
						producto.setPrecio(precio);
						HashTableProductos.modificarProductosPorCategoria(producto, HashTableProductos.getIndex());
					}else{
						out.println("objeto no encontrado");
					}				
					break;
				case '3':
					out.println("Ingrese categoria del producto a eliminar");
					categoria = lector.next();
					out.println("Ingrese codigo de barra del producto a eliminar");
					codigoBarra = lector.next();
					if(HashTableProductos.buscarProductoCodigoBarra(categoria, codigoBarra))
					{
						HashTableProductos.eliminarProductosPorCodigoBarra(categoria, HashTableProductos.getIndex());
					}else{
						out.println(" - Categoria Innexistente  o Codigo de Barra Erroneo- ");
					}
					break;
				case '4':
					out.println("Ingrese categoria del producto a buscar : ");
					categoria = lector.next();
					out.println("Lista de Productos por categoria");
					out.println("--------------------------------");	
					HashTableProductos.listarProductosPorCategoria(categoria);
					break;
				case '5':
					out.println("Lista de Categorias Ingresadas");
					out.println("------------------------------");
					HashTableProductos.mostrarCategoriasDisponibles();
					break;
				case '6':
					out.println("Saliendo del Sistema");
					break;
				default:
					out.println("Opcion Invalida");
					break;
			}
		}
		
	}
	
	private static void menu()
	{
	     out.println("********************************************");
	     out.println("********************************************");
	     out.println("***                                      ***");
	     out.println("***  Inventario de Productos             ***");
	     out.println("***                                      ***");
	     out.println("***  1.- Agregar Producto a Categoria    ***");
	     out.println("***  2.- Modificar Producto Categoria    ***");
	     out.println("***  3.- Eliminar Producto Categoria     ***");
	     out.println("***  4.- Listar por categoria            ***");
	     out.println("***  5.- Listar Todo                     ***");
	     out.println("***  6.- Salir                           ***");
	     out.println("***                                      ***");
	     out.println("********************************************");
	     out.println("********************************************");
	     out.print(" Ingrese Opcion : ");
	}
}
