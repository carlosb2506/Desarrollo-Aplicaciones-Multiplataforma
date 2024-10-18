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

        public Empleado(string nombre, int antiguedad, bool extranjero, int numHorasTrabajadas, niveles nivel)
        {

        }

        public double SalarioBase(int numHorasTrabajadas)
        {
            double v;

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

        public double Extras(int horasExtras)
        {
            double salarioExtra = horasExtras * (27 + (27 * 0.3));

            return salarioExtra;
        }

        public double Extranjero(bool extranjero)
        {
            double extraExtranjero;
            if (extranjero)
            {
                extraExtranjero = SalarioBase(numHorasTrabajadas) * 0.12;
            }
            else
            {
                extraExtranjero = 0;
            }
            return extraExtranjero;
        } 

        public double Nivel(niveles nivel)
        {
            double extraNivel =  0;
            switch (nivel)
            {
                case nivel.SENIOR:
                    extraNivel = SalarioBase(numHorasTrabajadas) * 0.25;
                    break;
                case nivel.ANALISTA:
                    extraNiveles = SalarioBase(numHorasTrabajadas) * 0.50;
                    break;
            }
            return extraNivel;
        }
        public double ImporteBruto()
        {
            return SalarioBase(numHorasTrabajadas) + Extras(horasExtras) + Extranjero(extranjero) + Nivel(nivel);
        }

        public double ImporteNeto()
        {
            double importeNeto;
            if (SalarioBase(numHorasTrabajadas) < 1400)
            {
                importeNeto = SalarioBase(numHorasTrabajadas) / 0.15;
            } else if (SalarioBase(numHorasTrabajadas) > 1401 || SalarioBase(numHorasTrabajadas) < 1700)
            {
                importeNeto = SalarioBase(numHorasTrabajadas) / 0.22;
            }
            else if (SalarioBase() > 1700)
            {
                importeNeto = SalarioBase(numHorasTrabajadas) / 0.27;
            }
        }
    }
}
