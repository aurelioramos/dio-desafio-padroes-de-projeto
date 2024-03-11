# Desafios 


## 1. Padronizando-um-sistema-de-gerenciamento-de-usuários
O Singleton é uma abordagem de design de software que visa assegurar a existência de apenas uma instância de uma classe e fornecer um ponto centralizado para acessá-la. Isso é especialmente benéfico em contextos nos quais é desejável manter uma única ocorrência de uma classe responsável pelo controle de um recurso compartilhado, como configurações, conexões de banco de dados ou caches.

Neste desafio, você deve criar um sistema de gerenciamento de usuários que permita adicionar e listar usuários. Você tem a opção de implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários em toda a aplicação. No entanto, a implementação do padrão Singleton é opcional e você pode optar por seguir uma abordagem diferente para resolver o desafio, se preferir.

### Especificações do Desafio:

Crie uma classe User com os seguintes atributos: id (inteiro) e name (string).
Implemente uma classe UserManager que siga o padrão Singleton. Esta classe deve possuir as seguintes funcionalidades:
1. Adicionar um novo usuário ao sistema, recebendo o nome como entrada.
2. Listar todos os usuários cadastrados.

No programa principal (main), siga as etapas abaixo:
1. Solicite ao usuário a quantidade de usuários que deseja cadastrar.
2. Peça ao usuário para informar os nomes dos usuários, um por linha.
3. Após receber os nomes e cadastrar os usuários, liste os usuários cadastrados.

### Entrada
Um número inteiro representando a quantidade de usuários que o usuário deseja cadastrar.

Para cada usuário a ser cadastrado, uma string contendo o nome do usuário.

### Saída
Uma lista com os nomes dos usuários cadastrados.

### Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada                                 	| Saida                                              	|
|-----------------------------------------	|----------------------------------------------------	|
| 2<br>Ada<br>Linus                       	| 1 - Ada<br>2 - Linus                               	|
| 3<br>Grace<br>Alan<br>Steve             	| 1 - Grace<br>2 - Alan<br>3 - Steve                 	|
| 4<br>Tim<br>Margaret<br>John<br>Richard 	| 1 - Tim<br>2 - Margaret<br>3 - John<br>4 - Richard 	|

**Nota:**
A implementação do padrão Singleton traz uma abordagem centralizada, com uma única instância do gerenciador de entidades, favorecendo a consistência dos dados e facilitando o acesso global. Por outro lado, optar por não usar o padrão permite maior flexibilidade, possibilitando várias instâncias independentes. A escolha depende das demandas do projeto, design e manutenção. Isso garante adaptabilidade entre diferentes linguagens ou contextos.Caso queira saber mais sobre o Design Pattern Singleton:
[https://refactoring.guru/pt-br/design-patterns/singleton](https://refactoring.guru/pt-br/design-patterns/singleton)

### Código inicial
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    private static final List<User> users = new ArrayList<>();

    // TODO: Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários

    public static void addUser(String name) {
        
    TODO("Implementar a lógica de adicionar um novo usuário na lista mutável $users.")

    }

    public static void listUsers() {

        TODO("Implementar a impressão dos $users, seguindo o padrão definido no enunciado.")

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            addUser(name);
        }

        listUsers();
    }
}
```

## 2. Implementando uma Calculadora Simples com Padrão Strategy
Você foi designado para criar uma calculadora simples em Java, aplicando o padrão de projeto Strategy para representar as operações matemáticas.

### Entrada
O programa deve solicitar ao usuário dois números e a operação desejada. As operações podem ser especificadas pelos seguintes sinais: + para soma, - para subtração, * para multiplicação e / para divisão. O usuário deve inserir o sinal correspondente à operação desejada.

### Saída
A calculadora deve utilizar o padrão Strategy para realizar a operação escolhida e exibir o resultado.

### Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada                                 	| Saida                                              	|
|-----------------------------------------	|----------------------------------------------------	|
| 100<br>10<br>/                         	| 10.0                                                 	|
| 9<br>4<br>*                            	| 36.0                                                 	|
| 4<br>3<br>+                            	| 7.0                                                 	|

### Código inicial
```java
import java.util.Scanner;

// Interface Strategy
interface Operation {
    double execute(double num1, double num2);
}

// Implementações concretas do Strategy
class AddOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1 + num2;
    }
}

class SubtractOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1 - num2;
    }
}

class MultiplyOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1 * num2;
    }
}

// TODO: Implementar uma nova estratégia de divisão sem tratamento de divisão por zero
class DivideOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        // TODO: Implementar lógica de divisão sem tratamento de divisão por zero
    }
}

// Contexto que utiliza a estratégia
class Calculator {
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double performOperation(double num1, double num2) {
        return operation.execute(num1, num2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Operation addOperation = new AddOperation();
        Operation subtractOperation = new SubtractOperation();

       //TODO: Criar instâncias do restante das operações
   

        // Criando a calculadora
        Calculator calculator = new Calculator();

        // Obtendo os números do usuário
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        // Obtendo a operação desejada
        String operationChoice = scanner.next();

        // Configurando a operação na calculadora
        switch (operationChoice) {
            case "+":
                calculator.setOperation(addOperation);
                break;
            case "-":
                calculator.setOperation(subtractOperation);
                break;
            case "*":
                calculator.setOperation(multiplyOperation);
                break;
            case "/":
                calculator.setOperation(divideOperation); // TODO: Utilizar a nova implementação de divisão
                break;
            default:
                System.out.println("Operação inválida.");
                return;
        }

        // Realizando a operação e exibindo o resultado
        double result = calculator.performOperation(num1, num2);
        System.out.println(result);
    }
}
```

##  3. Implementando um Catálogo de Produtos com Padrão Observer

Você deve aprimorar o sistema de monitoramento de produtos, adicionando a capacidade de exibir uma mensagem específica para cada usuário quando um novo produto é adicionado ao catálogo. Além disso, implemente a funcionalidade de permitir que os usuários cancelem sua assinatura para deixar de receber notificações sobre novos produtos.

### Entrada
O programa deve solicitar ao usuário que insira o nome do usuário para realizar a ação desejada.
Se o usuário deseja cancelar a assinatura, ele deve digitar "cancelar". Se desejar receber notificações, deve digitar qualquer outro valor.
Se o usuário optar por adicionar um novo produto, será solicitado o nome do produto a ser adicionado.

### Saída
Após cada ação, o programa deve exibir mensagens informativas para indicar se a assinatura foi cancelada com sucesso, se o usuário ainda está assinando notificações ou se o produto foi adicionado ao catálogo.

### Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada                                 	| Saida                                                       	|
|-----------------------------------------	|--------------------------------------------------------------	|
| TV<br>Smart<br>999<br>S                  	| Notificacao recebida: Novo produto adicionado - TV  	        |
| Smartphone<br>Apple<br>3000<br>S         	| Notificacao recebida: Novo produto adicionado - Smartphone    |
| Mouse<br>Sem fio<br>340<br>N           	| Programa Encerrado.                                          	|


### Código inicial
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface Observer
interface Observer {
    void update(String productName);
}

// Classe concreta Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("Notificacao recebida: Novo produto adicionado - " + productName);
    }
}

// Interface Observable
interface CatalogObservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String productName);
}

// Classe concreta Observable
class Catalog implements CatalogObservable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

  
    @Override
    public void notifyObservers(String productName) {
        // TODO: Implementar lógica para notificar apenas os usuários que desejam ser notificados
    }

    public void addProduct(String name, String description, double price) {
        notifyObservers(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando catálogo e usuário
        Catalog catalog = new Catalog();
        User user = new User("Usuário 1");

        // Inscricao do usuário no catálogo
        catalog.addObserver(user);

        // Adicionando novo produto
        String name = scanner.nextLine();
        String description = scanner.nextLine();
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consumir a quebra de linha após nextDouble
        String subscribeChoice = scanner.nextLine();

        // TODO: Verifique qual foi a escolha de notificação (S ou N) do usuário
       

        // Adicionando produto ao catálogo
        catalog.addProduct(name, description, price);
    }
}
```

## 4. Implementando um Carrinho de Compras com Padrão Strategy
Você está desenvolvendo um sistema simples de carrinho de compras. O desafio é implementar a funcionalidade de calcular o total da compra, permitindo que o usuário escolha entre diferentes estratégias de desconto, utilizando o padrão de projeto Strategy.

Entrada
O programa deve permitir que o usuário adicione produtos ao carrinho, informando o nome e o preço de cada produto. Em seguida, o usuário deve escolher a estratégia de desconto desejada entre duas opções: 10% de desconto ou frete grátis.

Saída
O programa deve calcular e exibir o total da compra com base na estratégia de desconto escolhida.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada                                 	| Saida                                	|
|--------------------------	|----------------------------------------------------	|
| Livro<br>45<br>1         	| Total da compra: R$40.5                              	|
| Air Fryer<br>200<br>2    	| Frete gratis aplicado<br>Total da compra: R$200.0   	|
| Celular<br>1000<br>1     	| Total da compra: R$900.0                             	|


### Código inicial
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface DiscountStrategy {
    double applyDiscount(double total);
}

// Implementações concretas do Strategy
class TenPercentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}

class FreeShipping implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        System.out.println("Frete gratis aplicado");
        return total;
    }
}

// Contexto que utiliza a estratégia
class ShoppingCart {
    private List<Double> products = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public void addProduct(double price) {
        products.add(price);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal() {
        // TODO: Implementar a lógica de cálculo do total
        return 0.0;  // Retornar o total calculado
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando instâncias das estratégias de desconto
        DiscountStrategy tenPercentDiscount = new TenPercentDiscount();
        DiscountStrategy freeShipping = new FreeShipping();

        // Criando o carrinho de compras
        ShoppingCart cart = new ShoppingCart();

        // Adicionando produtos ao carrinho
        String productName = scanner.nextLine();
        double productPrice = scanner.nextDouble();
        cart.addProduct(productPrice);

        // Escolhendo a estratégia de desconto
        int strategyChoice = scanner.nextInt();

        // Configurando a estratégia no carrinho
        switch (strategyChoice) {
            case 1:
                cart.setDiscountStrategy(tenPercentDiscount);
                break;
            case 2:
                cart.setDiscountStrategy(freeShipping);
                break;
            default:
                System.out.println("Escolha invalida. Nenhum desconto aplicado.");
        }

        // TODO: Chamar o método calculateTotal e exibir o resultado
    }
}
```

## 5. Implementando um Adaptador para Conversão de Moedas
O padrão de projeto Adapter é um padrão de projeto estrutural que permite que objetos com interfaces incompatíveis trabalhem juntos. Ele atua como um intermediário, adaptando a interface de uma classe para outra interface esperada pelo cliente.

Neste desafio, você deverá implementar um conversor de moedas que permitirá que valores monetários sejam convertidos de dólares americanos (USD) para euros (EUR). Embora exista uma taxa de conversão direta de 1 USD = 0.85 EUR, o nosso sistema inicialmente só suportava a conversão de USD para libras esterlinas (GBP). Utilizando o padrão Adapter, você deve adaptar esse sistema antigo para fornecer a nova funcionalidade de conversão direta para EUR, usando a conversão intermediária para GBP.

Entrada
Um valor em dólares americanos USD (Double).

Saída
O valor convertido para euros EUR (Double) usando o adaptador.

Taxa de conversão direta (para referência):
1 USD = 0.85 EUR

Taxas de conversão para a adaptação:
1 USD para GBP = 0.80
1 GBP para EUR = 1.0625

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada   | Saida                    	|
|----------	|--------------------------	|
| 200      	| USD: 200.0<br>EUR: 170.0 	|
| 150    	| USD: 150.0<br>EUR: 127.5	|
| 1000.0  	| USD: 1000.0<br>EUR: 850.0	|

Nota:
O padrão Adapter é uma ferramenta valiosa para lidar com incompatibilidades de interface e integrar componentes heterogêneos. No entanto, é importante avaliar cuidadosamente sua utilização para garantir que os benefícios superem os possíveis custos em termos de complexidade e desempenho.

Caso queira saber mais sobre o Design Pattern Adapter:
[https://refactoring.guru/pt-br/design-patterns/adapter](https://refactoring.guru/pt-br/design-patterns/adapter)

### Código inicial
```java
import java.util.Scanner;

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    public double convertUSDtoGBP(double amount) {
        return amount * 0.80; // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
    private final OldCurrencyConverter oldConverter;

    public CurrencyAdapter(OldCurrencyConverter oldConverter) {
        this.oldConverter = oldConverter;
    }

    // TODO: Implementar método de conversão de USD para outra moeda (por exemplo, JPY)
    // Dica: Você pode criar métodos adicionais conforme necessário.

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        OldCurrencyConverter oldConverter = new OldCurrencyConverter();
        CurrencyAdapter adapter = new CurrencyAdapter(oldConverter);

        // TODO: Chamar o método para converter USD para a nova moeda desejada (por exemplo, JPY)

        // TODO: Imprimir o resultado da conversão

        System.out.println("USD: " + input);
        // TODO: Imprimir o resultado da conversão com a nova moeda (por exemplo, JPY)
    }
}
```
