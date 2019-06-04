package gt.umg.is_ht3;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ProductArrayApplication {

    public static void main(String[] args) {
        long[] input;
        long[] result;
        //ejemplo 1, cadena basica {1,2,3,4,5}        
        input = new long[] {1,2,3,4,5};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));

        //ejemplo 2, cadena vacia
        input = new long[] {};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 3, enviando un 0
        input = new long[] {0};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 4, enviando un 1
        input = new long[] {1};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 5, cadena doble {1,2}
        input = new long[] {1,2};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 6, cadena nula
        input = null;
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 7, cadena de longitud 0
        input = new long[0];
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 8, cadena con multiples 0
        input = new long[] {1, 0, 3, 0, 5};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 9, cadena con un 0
        input = new long[] {1, 2, 3, 0, 5};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));
        
        //ejemplo 10, cadena simple {3,9,1997}
        input = new long[] {3,9,1997};
        result = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(result));

    }

    public static long[] calculateProductArrayBasic(long[] input)
    {
        if(input == null)
        {
            return null;
        }
        
        long[] inicio = new long[input.length];
        long[] fin = new long[input.length];
        long[] resultado = new long[input.length];
        long[] union;
        
        for(int i=0; i<input.length; i++)
        {
            inicio = Arrays.copyOfRange(input, 0, i);
            fin = Arrays.copyOfRange(input, i+1, input.length);
            union = new long[inicio.length+fin.length];
            System.arraycopy(inicio, 0, union, 0, inicio.length);
            System.arraycopy(fin, 0, union, inicio.length, fin.length);
            
            resultado[i] = Arrays.stream(union).reduce((a,b) -> a*b).orElse(1);
            
        }
        
        return resultado;
    }
    
}
