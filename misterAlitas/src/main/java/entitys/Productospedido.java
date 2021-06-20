package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "productospedido")
@NamedQueries({
        @NamedQuery(name = "Productospedido.findAll", query = "SELECT p FROM Productospedido p"),
        @NamedQuery(name = "Productospedido.findByIdproductospedidos", query = "SELECT p FROM Productospedido p WHERE p.idproductospedidos = :idproductospedidos"),
        @NamedQuery(name = "Productospedido.findByCantidad", query = "SELECT p FROM Productospedido p WHERE p.cantidad = :cantidad")})
public
class Productospedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductospedidos")
    private Integer idproductospedidos;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @ManyToOne
    private Pedido idpedido;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Producto idproducto;

    public Productospedido() {
    }

    public Productospedido(Integer idproductospedidos) {
        this.idproductospedidos = idproductospedidos;
    }

    public Integer getIdproductospedidos() {
        return idproductospedidos;
    }

    public void setIdproductospedidos(Integer idproductospedidos) {
        this.idproductospedidos = idproductospedidos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductospedidos != null ? idproductospedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productospedido)) {
            return false;
        }
        Productospedido other = (Productospedido) object;
        if ((this.idproductospedidos == null && other.idproductospedidos != null) || (this.idproductospedidos != null && !this.idproductospedidos.equals(other.idproductospedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Productospedido[ idproductospedidos=" + idproductospedidos + " ]";
    }

}
