using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio2
{
    public class Empleado
    {
        private string nombre;
        private int antiguedad;
        public bool extranjero;
        public int numHorasTrabajadas;
        public enum niveles { JUNIOR, SENIOR, ANALISTA };

        private niveles nivel;

        //PROPIEDADES
        public string Nombre
        {
            get { return this.nombre; }
            set { 
                this.nombre = value;
            }
        }

        public int Antiguedad
        {
            get { return this.antiguedad; }
            set
            {
                this.antiguedad = value;
            }
        }

        public bool Extranjero
        {
            get { return this.extranjero; }
            set { this.extranjero = value; }
        }

        public int NumHorasTrabajadas
        {
            get { return this.numHorasTrabajadas; }
            set { this.numHorasTrabajadas = value; }
        }

        public niveles Nivel
        {
            get { return this.nivel; }
            set { this.nivel = value; }
        }

        //MÉTODOS

        public int SalarioBase(int numHorasTrabajadas)
        {
            int v;

            if (numHorasTrabajadas <= 40)
            {
                v = numHorasTrabajadas * 27;
            }
            else
            {
                v = 40 * 27;
            }
            return v;
        }


    }
}
