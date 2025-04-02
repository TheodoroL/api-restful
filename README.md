# Diagrama de Classes

Abaixo está o diagrama de classes representando um cliente bancário.

```mermaid
classDiagram
    class Client {
        +Account account
        +Card card
        +List~Feature~ features
        +List~News~ news
    }

    class Account {
        +String number
        +String agency
        +Double balance
        +Double limit
    }

    class Card {
        +String number
        +Double limit
    }

    class Feature {
        +String icon
        +String description
    }

    class News {
        +String icon
        +String description
    }

    Client --> Account
    Client --> Card
    Client --> Feature
    Client --> News
   ```
Nesse diagrama:
- **Client** (Cliente) representa o cliente do banco.
- **Account** (Conta) contém informações como número da conta, agência, saldo e limite.
- **Card** (Cartão) tem o número do cartão e limite disponível.
- **Feature** (Funcionalidades) lista características como o PIX.
- **News** (Notícias) lista as novidades relacionadas ao cliente.