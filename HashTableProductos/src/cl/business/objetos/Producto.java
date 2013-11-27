package cl.business.objetos;

public class Producto {
	
	String codigoBarra;
	String categoria;
	String nombre;
	int precio;
	
	public String getCodigoBarra() 
	{
		return codigoBarra;
	}
	
	public void setCodigoBarra(String codigoBarra) 
	{
		this.codigoBarra = codigoBarra;
	}
	
	public String getCategoria() 
	{
		return categoria;
	}
	
	public void setCategoria(String categoria) 
	{
		this.categoria = categoria;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public int getPrecio() 
	{
		return precio;
	}
	
	public void setPrecio(int precio) 
	{
		this.precio = precio;
	}	
}
