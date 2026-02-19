package backend.servicios;

import java.io.Serializable;
import java.util.Date;

public class Venta implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int id;
    private Date fecha;
    private int idACliente;
    private double totalVenta;
    private int idAVendedor; // referenci al vendedor que realizo la venta

    public Venta()
    {
        this.id = -1;
        this.fecha = new Date();
        this.idACliente = -1;
        this.totalVenta = 0;
        this.idAVendedor = -1;
    }

    public Venta(
        int id,
        Date fecha,
        int idACliente,
        double totalVenta,
        int idAVendedor
    ){
        this.id = id;
        this.fecha = fecha;
        this.idACliente = idACliente;
        this.totalVenta = totalVenta;
        this.idAVendedor = idAVendedor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdACliente() {
		return idACliente;
	}

	public void setIdACliente(int idACliente) {
		this.idACliente = idACliente;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

    public double getTotalVenta()
    {
    	return this.totalVenta;
    }

	public int getIdAVendedor() {
		return idAVendedor;
	}

	public void setIdAVendedor(int idAVendedor) {
		this.idAVendedor = idAVendedor;
	}
}
