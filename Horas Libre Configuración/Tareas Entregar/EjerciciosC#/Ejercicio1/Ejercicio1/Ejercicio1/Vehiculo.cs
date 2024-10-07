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
            set {

                if(this.numPuerta != 3 || this.numPuerta != 5 )
                {  this.numPuerta = 3;}
                else
                {
                    this.numPuerta = value;
                }
            }
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
            set { 
                if (this.numAirbags > 6 || this.numAirbags < 0 )
                {
                    this.numAirbags = 6;
                }

                this.numAirbags = value; }
        }

        public Vehiculo(string matricula, marca marcaCoche, tipo tipoCoche, int numPuerta, double precioBase, bool llantasAleacion, bool techoSolar, int numAirbags)
        {
            this.matricula = matricula;
            this.marcaCoche = marcaCoche;
            this.tipoCoche = tipoCoche;
            NumPuerta = numPuerta;
            this.precioBase = precioBase;
            this.llantasAleacion = llantasAleacion;
            this.techoSolar = techoSolar;
            NumAirbags = numAirbags;
        }

        public double PrecioTecho(bool techoSolar)
        {
            double precio = 0;

            if (techoSolar)
            {
                precio = this.precioBase + (this.precioBase * 0.23);
            }
            
            return precio;
        }

        public double PrecioPuerta(int numPuerta)
        {
            double precio = 0;

            if (numPuerta == 3)
            {
                precio = this.precioBase - (this.precioBase * 0.5);
            }
            return precio;
        }

        public double PrecioMarca(marca marcaCoche, tipo tipoCoche)
        {
            double precio = 0;

            if(marcaCoche == marca.AUDI && tipoCoche == tipo.DEPORTIVO)
            {
                precio = this.precioBase + (this.precioBase * 1.2);
            }
            return precio;

        }

        public double PrecioLlantas(bool lllantasAleacion)
        {
            double precio = 0;
            if (lllantasAleacion)
            {
                precio = this.precioBase + 2500;
            }
            return precio;
        }

        public double PrecioAirbag(int numAirbags)
        {
            double precio = 0;
            switch (numAirbags) 
            {
                case 1: precio = this.precioBase + (this.precioBase * 0.15); 
                    break;
                case 2: precio = this.precioBase + (this.precioBase * 0.3);
                    break;
                case 3:
                    precio = this.precioBase + (this.precioBase * 0.45);
                    break;
                case 4:
                    precio = this.precioBase + (this.precioBase * 0.6);
                    break;
                case 5:
                    precio = this.precioBase + (this.precioBase * 0.75);
                    break;
                case 6:
                    precio = this.precioBase + (this.precioBase * 0.9);
                    break;
            }
            return precio;

        }
        public double ImporteTotal()
        {
            double precio = 0;

            precio = this.precioBase + PrecioTecho(true) + PrecioPuerta(5) + PrecioMarca(marca.AUDI, tipo.DEPORTIVO) + PrecioLlantas(true) + PrecioAirbag(6);

            return precio;
        }

    }
}
