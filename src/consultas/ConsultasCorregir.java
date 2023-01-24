package consultas;

import java.util.List;

import modelo.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Account;

import util.SessionFactoryUtil;

public class ConsultasCorregir {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        {
//            System.out.println("----------- Nombres de los de Departamentos-----------");
//            List<String> deptList = session.createQuery(" select d.name FROM Dept d ").list();
//
//            for (String nombre : deptList) {
//                System.out.println("Nombre: " + nombre);
//            }
            //SE CAMBIA EL NOMBRE DE LA CLASE Y DEL ATRIBUTO EN LA CONSULTA
            System.out.println("----------- Nombres de los de Departamentos-----------");
            List<String> deptList = session.createQuery("select d.dname FROM Departamento d ").list();

            for (String nombre : deptList) {
                System.out.println("Nombre: " + nombre);
            }
        }

        {
//            System.out.println("----------- Nombres de los empleados cuyo nombre comienza por M -----------");
//            List<String> empList = session.createQuery("Select e.name from Emp e where e.name like 'M%'").list();
//
//            for (String nombre : empList) {
//                System.out.println("Nombre: " + nombre);
//            }
            //SE CAMBIA EL NOMBRE DEL ATRIBUTO EN LA CONSULTA
            System.out.println("----------- Nombres de los empleados cuyo nombre comienza por M -----------");
            List<String> empList = session.createQuery("Select e.ename from Emp e where e.ename like 'M%'").list();

            for (String nombre : empList) {
                System.out.println("Nombre: " + nombre);
            }
        }

        {
//            System.out.println("----------- Encontrar los empleados sin jefe -----------");
//            List<String> empList = session.createQuery("Select e from Emp e where e.MGR is null").list();
//
//            for (String nombre : empList) {
//                System.out.println("Nombre: " + nombre);
//            }
            //SE CAMBIA e.MGR por e.emp --> EL JEFE EN LA CLASE ES UN emp
            System.out.println("----------- Encontrar los empleados sin jefe -----------");
            List<Emp> empList = session.createQuery("Select e from Emp e where e.emp is null").list();

            for (Emp nombre : empList) {
                System.out.println("Nombre: " + nombre);
            }
        }

        {
//            System.out.println("----------- Mostrar los ids de las cuentas sin movimientos-----------");
//            List<Account> cuentas = session.createQuery("Select * from Account a  having "
//                            + "((size(a.accMovementsForAccountDestId) =0) and (size(a.accMovementsForAccountOriginId)=0))")
//                    .list();
//
//            for (Account a : cuentas) {
//                System.out.println("Id: " + a.getAccountno());
//            }
            //SE CAMBIA EL * POR a
            //SE CAMBIA EL HAVING POR WHERE
            //SE CAMBIA EL SIZE
            System.out.println("----------- Mostrar los ids de las cuentas sin movimientos-----------");
            List<Integer> cuentasIds = session.createQuery("Select a.accountno from Account a where"
                            + "(size(a.accMovements) =0) ")
                    .list();

            for (Integer a : cuentasIds) {
                System.out.println("Id: " + a);
            }
        }

        session.close();
        sessionFactory.close();

    }
}
