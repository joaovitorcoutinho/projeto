import java.util.HashMap;
import java.util.Map;

public class Criptografia {

    private static final Map<Character, String> chaveCriptografia = new HashMap<>();
    private static final Map<String, Character> chaveDescriptografia = new HashMap<>();

    static {
        chaveCriptografia.put('e', "enter");
        chaveCriptografia.put('i', "imes");
        chaveCriptografia.put('a', "ai");
        chaveCriptografia.put('o', "ober");
        chaveCriptografia.put('u', "ufat");

        for (Map.Entry<Character, String> entry : chaveCriptografia.entrySet()) {
            chaveDescriptografia.put(entry.getValue(), entry.getKey());
        }
    }

    public static String criptografar(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (chaveCriptografia.containsKey(c)) {
                resultado.append(chaveCriptografia.get(c));
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    public static String descriptografar(String textoCriptografado) {
        StringBuilder resultado = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (char c : textoCriptografado.toCharArray()) {
            if (Character.isLetter(c)) {
                buffer.append(c);
            } else {
                String chave = buffer.toString();
                if (chaveDescriptografia.containsKey(chave)) {
                    resultado.append(chaveDescriptografia.get(chave));
                } else {
                    resultado.append(chave);
                }
                resultado.append(c);
                buffer.setLength(0);
            }
        }
        String chave = buffer.toString();
        if (chaveDescriptografia.containsKey(chave)) {
            resultado.append(chaveDescriptografia.get(chave));
        } else {
            resultado.append(chave);
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        String texto = "gato";
        String textoCriptografado = criptografar(texto);
        System.out.println("Texto criptografado: " + textoCriptografado);
        String textoDescriptografado = descriptografar(textoCriptografado);
        System.out.println("Texto descriptografado: " + textoDescriptografado);
    }
}