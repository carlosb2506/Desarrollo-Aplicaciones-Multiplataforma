using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio1
{
    public class Vehiculo
    {
        private string matricula;

        public enum marca { TOYOTA, AUDI, ALFAROMEO };

        private marca marcaCoche;
        public enum tipo { TODOTERRENO, SEDAN, DEPORTIVO };
        private tipo tipoCoche;

        private int numPuerta;

        private double precioBase;

        private bool llantasAleacion;

        private bool techoSolar;

        private int numAirbags;

        public string Matricula
        {
            get { return matricula; }
            set { matricula = value; }
        }

        public marca MarcaCoche
        {
            get { return marcaCoche; }
            set { marcaCoche = value; }
        }

        public tipo TipoCoche
        {
            get { return tipoCoche; }
            set { tipoCoche = value; }
        }

        public int NumPuerta
        {
            get { return numPuerta; }
            set { numPuerta = value; }
        }
        public double PrecioBase
        {
            get { return precioBase; }
            set { precioBase = value; }
        }

        public bool LantasAleacion
        {
            get { return llantasAleacion; }
            set { llantasAleacion = value; }
        }

        public bool TechoSolar
        {
            get { return techoSolar; }
            set { techoSolar = value; }
        }
        public int NumAirbags
        {
            get { return numAirbags; }
            set { numAirbags = value; }
        }

        //public Vehiculo(string matricula, string marcaCoche, string tipoCoche, int numPuerta, double precioBase, bool llantasAleacion, bool techoSolar, int numAirbags);
        //{
        //    this.matricula = matricula;
        //    this.marcaCoche = marcaCoche;
        //    this.tipoCoche = tipoCoche;
        //    this.numPuerta = numPuerta;
        //    this.precioBase = precioBase;
        //    this.llantasAleacion = llantasAleacion;
        //    this.techoSolar = techoSolar;
        //    this.numAirbags = numAirbags;
        //}

        public double precioTecho(bool techoSolar)
        {

            if (techoSolar == true)
            {
                this.precioBase = (this.precioBase * 1.023);
            }
            else
            {
                this.precioBase;
            }

            return this.precioBase;

        }

        public double precioPuerta(int numPuerta)
        {
            if (numPuerta == 3)
            {
                this.precioBase = this.precioBase *
            }
        }

    }
}
