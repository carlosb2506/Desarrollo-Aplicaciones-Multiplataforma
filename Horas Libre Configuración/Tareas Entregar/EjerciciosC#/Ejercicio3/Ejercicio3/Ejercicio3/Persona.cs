using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio3
{
    public class Persona
    {
        private string nombre;
        private string dni;
        private char sexo;
        private int edad;
        private double peso;
        private double altura;

        public string Nombre{
            get{ return nombre; } 
            set{ nombre = value; }
        }
        public string Dni
        {
            get { return dni;  }
            set { dni = value; }
        }
        public char Sexo
        {
            get { return sexo; }
            set { sexo = value; }
        }
        public int Edad
        {
            get { return edad; }
            set { edad = value; }
        }
        public double Peso
        {
            get { return peso; }
            set { peso = value; }
        }
        public double Altura
        {
            get { return altura; }
            set { altura = value; }
        }


        public Persona(string nombre, string dni, char sexo, int edad, double peso, double altura)
        {
            this.nombre = nombre;
            this.dni = dni;
            this.sexo = sexo;
            this.edad = edad;
            this.peso = peso;
            this.altura = altura;
        }
        public Persona(string nombre, int edad, char sexo)
        {
            this.nombre = nombre;
            this.dni = "";
            this.peso = 0;
            this.edad= edad;
            this.sexo= sexo;
            this.altura = 0;

        }
        public Persona()
        {
            this.nombre = "";
            this.dni = "";
            this.peso = 0;
            this.edad = 0;
            this.sexo = '';
            this.altura = 0;
        }
    }

    public int CalcularIMC(double peso, double altura)
    {
        int result = 0;
        int calculo = (int) (peso / Math.Pow(altura, 2));
        
        if (calculo < 20)
        {
            result = -1;
        }
        else if (calculo >= 20 && calculo <= 25)
        {
            result = 0;
        } else if (calculo > 25)
        {
            result = 1;
        }

        return result;
    }

    public bool MayorDeEdad(int edad)
    {
        bool mayor = false;

        if (edad >= 18)
        {
            mayor = true;
        }
        else
            mayor = false;

        return mayor;
    }

    public void ComprobarSexo(char sexo)
    {
       
        if (sexo.Equals('H') || sexo.Equals('h') || sexo.Equals('M') || sexo.Equals('m'))
        {
            Sexo = 
        }
    }
}
