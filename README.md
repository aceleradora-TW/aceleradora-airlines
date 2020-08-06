# aceleradora-airlines

Para rodar o projeto localmente:

```
./gradlew bootrun
```

## Conceitos

#### Código IATA

> O código aeroportuário IATA é uma sigla composta por três letras, utilizada para designar os aeroportos em todo o mundo
>
>  \- [Wikipédia](https://pt.wikipedia.org/wiki/C%C3%B3digo_aeroportu%C3%A1rio_IATA)

Dentro da API, cidades e aeroportos são representados por seus códigos IATA.


#### Código ISO de Países

> ISO 3166-1 alpha-2 codes are two-letter country codes defined in ISO 3166-1, part of the ISO 3166 standard published 
> by the International Organization for Standardization (ISO), to represent countries, dependent territories, and 
> special areas of geographical interest.
> 
> \- [Wikipédia](https://pt.wikipedia.org/wiki/C%C3%B3digo_aeroportu%C3%A1rio_IATA)

Dentro da API, países são representados por seus códigos ISO 3166-1 alpha-2.

#### Carrier

Carrier é o código da empresa aérea responsável pelo voo.

#### Voo (Flight)

Um voo contém:
 - Um ponto de partida, constituído por cidade, aeroporto e país
 - Um ponto de chegada, constituído por cidade, aeroporto e país
 - Um número de voo, constituído por carrier e número
 
 
#### Itinerário (Itinerary)

Um itinerário representa uma viagem com zero ou mais paradas. Um itinerário sem paradas é dito direto.

Itinerário direto de Porto Alegre para São Paulo:

```
POA > SAO
```

Itinerário de ida e volta Porto Alegre para São Paulo, São Paulo para Porto Alegre:

```
POA > SAO > POA
```

Itinerário aberto (que não volta para sua origem):

```
POA > SAO > BCN > NYC
```

## API

Host: http://aceleradora-airlines.herokuapp.com

### Buscar todos os voos

**Requisição:**

```http request
GET /flights
```

**Resposta:**

```json
[
    {
        "number": "1060",
        "departure": {
            "airport": "POA",
            "city": "POA",
            "country": "BR"
        },
        "arrival": {
            "airport": "CGH",
            "city": "SAO",
            "country": "BR"
        },
        "carrier": "AZU"
    }
]

```


### Buscar voos por carrier

**Requisição:**

```http request
GET /flights/carrier/{carrier}
```

**Resposta:**

Status:

```http request
200 OK
```

Corpo:

```json
[
    {
        "number": "1060",
        "departure": {
            "airport": "POA",
            "city": "POA",
            "country": "BR"
        },
        "arrival": {
            "airport": "CGH",
            "city": "SAO",
            "country": "BR"
        },
        "carrier": "AZU"
    }
]
```

### Buscar voo por informações de partida

**Requisição:**

```http request
GET /flights/departing
```

**Parâmetros:**

|Nome|Obrigatório|Exemplo|Descrição|
|---|---|---|---|
|city|Não|SAO|Código IATA da cidade de partida|
|airport|Não|GRU|Código IATA do aeroporto de partida|
|country|Não|BR|Código ISO do país de partida|

Status:

```http request
200 OK
```

Corpo:

```json
[
    {
        "number": "1060",
        "departure": {
            "airport": "POA",
            "city": "POA",
            "country": "BR"
        },
        "arrival": {
            "airport": "CGH",
            "city": "SAO",
            "country": "BR"
        },
        "carrier": "AZU"
    }
]
```

### Buscar voo por informações de chegada

**Requisição:**

```http request
GET /flights/arriving
```

**Parâmetros:**

|Nome|Obrigatório|Exemplo|Descrição|
|---|---|---|---|
|city|Não|SAO|Código IATA da cidade de chegada|
|airport|Não|GRU|Código IATA do aeroporto de chegada|
|country|Não|BR|Código ISO do país de chegada|

Status:

```http request
200 OK
```

Corpo:

```json
[
    {
        "number": "1060",
        "departure": {
            "airport": "POA",
            "city": "POA",
            "country": "BR"
        },
        "arrival": {
            "airport": "CGH",
            "city": "SAO",
            "country": "BR"
        },
        "carrier": "AZU"
    }
]
```

### Criar um itinerário

**Requisição:**
```http request
POST /itinerary
```

**Cabeçalhos:**

```http request
Content-Type: application/json
```

**Corpo:**

```json
{
    "segments": [
        {
            "origin": {
                "airport": "POA",
                "city": "POA",
                "country": "BR"
            },

            "destination": {
                "airport": "JFK",
                "city": "NYC",
                "country": "US"
            }

        }
    ]
}
```

**Resposta:**

Status:

```http request
201 Created
```

Corpo:

Importante observar que a resposta contém o ID do registro que foi criado. Este ID é utilizado para pesquisa e 
remoção do itinerário.

```json
{
    "segments": [
        {
            "origin": {
                "airport": "POA",
                "city": "POA",
                "country": "BR"
            },
            "destination": {
                "airport": "JFK",
                "city": "NYC",
                "country": "US"
            }
        }
    ],
    "id": "04274824-f58a-4ed4-b105-ec3f82c5e3cf"
}
```

### Buscar um itinerário específico

**Requisição:**

```http request
GET /itinerary/{id}
```
**Resposta:**

Status:

```http request
200 OK
```

Corpo:
```json
{
    "segments": [
        {
            "origin": {
                "airport": "POA",
                "city": "POA",
                "country": "BR"
            },
            "destination": {
                "airport": "JFK",
                "city": "NYC",
                "country": "US"
            }
        }
    ],
    "id": "04274824-f58a-4ed4-b105-ec3f82c5e3cf"
}
```

### Remover um itinerário

**Requisição:**

```http request
DELETE /itinerary/{id}
```

Status:

```http request
200 OK
```

Corpo: Sem corpo
