package cl.business.objetos;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class HashTableProductos {
	
	public static Hashtable<String, List<Producto>> listaProductos; 
	private static int index;
	private static List<Producto> listaAuxProd;
	
	static
	{
		listaProductos = new Hashtable<String, List<Producto>>();
	}
	
	public static void ingresarProductoLista(String categoria, List<Producto> p, Producto prod)
	{
		if(listaProductos.containsKey(categoria.toLowerCase()))
		{
			p = listaProductos.get(categoria.toLowerCase());
			p.add(prod);
			listaProductos.put(categoria.toLowerCase(), p);
		}else{
			listaProductos.put(categoria.toLowerCase(), p);
		}
	}
	
	public static void listarProductosPorCategoria(String categoria)
	{
		if(listaProductos.containsKey(categoria.toLowerCase()))
		{
			List<Producto> p = listaProductos.get(categoria.toLowerCase());
			for(Producto productos : p)
			{
				System.out.println(" ");
				System.out.println("codigo de barra : " + productos.getCodigoBarra());
				System.out.println("Categoria : " + productos.getCategoria());
				System.out.println("Nombre : " + productos.getNombre());
				System.out.println("Precio : " + productos.getPrecio());
				System.out.println(" ");
			}
		}
	}
	
	public static boolean buscarProductoCodigoBarra(String categoria, String codigoBarra)
	{
		boolean existe = false;
		int posicion = 0;
		if(listaProductos.containsKey(categoria.toLowerCase()))
		{
			List<Producto> p = listaProductos.get(categoria.toLowerCase());
			setListaAuxProd(p);
			for(Producto pdto : p)
			{
				if(pdto.getCodigoBarra().equalsIgnoreCase(codigoBarra))
				{
					existe = true;
					posicion = p.indexOf(pdto);
					setIndex(posicion);
					System.out.println("------------------------------------------------");
					System.out.println("- Informacion del Producto                     -");
					System.out.println("-                                              -");
					System.out.println("- Codigo Barra : " + pdto.getCodigoBarra() + " -");
					System.out.println("- Categoria : " + pdto.getCategoria() + "      -");
					System.out.println("- Nombre : " + pdto.getNombre() +            " -");
					System.out.println("- Precio : " + pdto.getPrecio() +            " -");
					System.out.println("------------------------------------------------");
				}
			}
		}
		return existe;
	}
	
	public static void modificarProductosPorCategoria(Producto prod, int indice)
	{
		List<Producto> p = getListaAuxProd();
		
		if(listaProductos.containsKey(prod.getCategoria().toLowerCase()))
		{
			p.remove(indice);
			List<Producto> pnewcat = getProductosNuevaCat(prod.getCategoria().toLowerCase());
			pnewcat.add(prod);
			listaProductos.put(prod.getCodigoBarra().toLowerCase(), p);
			System.out.println(" - Producto Modificado -");
		}else{
			System.out.println("la categoria nueva a cambiar del producto no existe");
		}
	}
     
	
	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		HashTableProductos.index = index;
	}

	public static List<Producto> getListaAuxProd() {
		return listaAuxProd;
	}

	public static void setListaAuxProd(List<Producto> listaAuxProd) {
		HashTableProductos.listaAuxProd = listaAuxProd;
	}
	
	public static List<Producto> getProductosNuevaCat(String cat)
	{
		List<Producto> p;
		p = listaProductos.get(cat);
		return p;
	}
	
	public static void eliminarProductosPorCodigoBarra(String categoria, int indice)
	{
		List<Producto> p = getListaAuxProd();
		
		if(listaProductos.containsKey(categoria.toLowerCase()))
		{
			p.remove(indice);
			listaProductos.put(categoria.toLowerCase(), p);
			System.out.println(" - Producto Eliminado -");
		}else{
			System.out.println("No se pudo eliminar el producto");
		}
	}
	
	public static void mostrarCategoriasDisponibles()
	{
		Enumeration<String> categorias = listaProductos.keys();
		
		while (categorias.hasMoreElements()) 
		{
			System.out.println("[ " + categorias.nextElement() + " ]");
		}
		
	}
     
}
