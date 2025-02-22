# Exercícios para praticar SOLID!
## Exercício 5: Dependency Inversion Principle (DIP)

### Enunciado:
Você está criando um sistema para gerenciar dispositivos de entrada de um computador. Atualmente, a classe Computador depende diretamente da classe Teclado, o que dificulta a substituição por outros dispositivos, como um mouse. Refatore o código para que ele siga o Princípio da Inversão de Dependência (DIP).

Código inicial (errado):
```java
public class Teclado {
    public void digitar() {
        System.out.println("Digitando...");
    }
}

public class Computador {
    private Teclado teclado;

    public Computador() {
        this.teclado = new Teclado();
    }
}
```

### Tarefa:
- Crie uma interface DispositivoEntrada com o método usar().
- Faça com que Teclado implemente essa interface.
- Modifique a classe Computador para depender da interface, e não da implementação concreta.

## Resolução
O Princípio da Inversão de Dependência (DIP) estabelece que módulos de alto nível não devem depender de módulos de baixo nível, mas sim de abstrações. Além disso, as abstrações não devem depender de implementações concretas, mas as implementações devem depender das abstrações.

- Classe Computador

```java
package model;

public class Computador {
    private final DispositivoEntrada dispositivo;

    public Computador(DispositivoEntrada dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void usarDispositivo() {
        dispositivo.usar();
    }
}
```
- Interface DipositivoEntrada

```java
package model;

public interface DispositivoEntrada {
    void usar();
}
```
- Classe Mouse
```java
package service;

import model.DispositivoEntrada;

public class Mouse implements DispositivoEntrada {
    @Override
    public void usar() {
        System.out.println("Movendo o ponteiro...");
    }
}
```
- Classe Teclado
```java
package service;

import model.DispositivoEntrada;

public class Teclado implements DispositivoEntrada {
    @Override
    public void usar() {
        System.out.println("Digitando...");
    }
}
```
## Conclusão
Foi criada a interface DispositivoEntrada, que define o método usar(). As classes Teclado e Mouse implementam essa interface, permitindo que diferentes dispositivos de entrada sejam usados de forma intercambiável. A classe Computador foi modificada para depender da interface DispositivoEntrada, em vez de uma implementação concreta. Com isso, o Computador pode trabalhar com qualquer dispositivo que implemente a interface, tornando o código mais flexível e fácil de expandir. Essa abordagem desacopla o módulo de alto nível (Computador) das implementações de baixo nível (Teclado, Mouse).