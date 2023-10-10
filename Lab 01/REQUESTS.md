## Request Examples

### Enlist Wizard

```
curl --location 'http://localhost:8080/api/wizards/enlist' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Harry Potter",
    "age": 17,
    "house": "GRYFFINDOR",
    "bloodStatus": "HALF_BLOOD",
    "role": "STUDENT",
    "wand": {
        "wood": "HOLLY",
        "core": "PHOENIX_FEATHER",
        "length": 11.0
    }
}'
```

```
curl --location 'http://localhost:8080/api/wizards/enlist' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Hermione Granger",
    "age": 17,
    "house": "GRYFFINDOR",
    "bloodStatus": "MUGGLE_BORN",
    "role": "STUDENT",
    "wand": {
        "wood": "VINE",
        "core": "DRAGON_HEARTSTRING",
        "length": 10.75
    }
}'
```

```
curl --location 'http://localhost:8080/api/wizards/enlist' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Ron Weasley",
    "age": 17,
    "house": "GRYFFINDOR",
    "bloodStatus": "PURE_BLOOD",
    "role": "STUDENT",
    "wand": {
        "wood": "WILLOW",
        "core": "UNICORN_HAIR",
        "length": 12.0
    }
}'
```

```
curl --location 'http://localhost:8080/api/wizards/enlist' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Draco Malfoy",
    "age": 17,
    "house": "SLYTHERIN",
    "bloodStatus": "PURE_BLOOD",
    "role": "STUDENT",
    "wand": {
        "wood": "HAWTHORN",
        "core": "UNICORN_HAIR",
        "length": 10.0
    }
}'
```

```
curl --location 'http://localhost:8080/api/wizards/enlist' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Cedric Diggory",
    "age": 17,
    "house": "HUFFLEPUFF",
    "bloodStatus": "HALF_BLOOD",
    "role": "STUDENT"
}'
```

```
curl --location 'http://localhost:8080/api/wizards/enlist' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Luna Lovegood",
    "age": 16,
    "house": "RAVENCLAW",
    "bloodStatus": "PURE_BLOOD",
    "role": "STUDENT"
}'
```

### Summon Wizard

```
curl --location 'http://localhost:8080/api/wizards/summon/${WIZARD_ID}'
```

### Summon All Wizards

```
curl --location 'http://localhost:8080/api/wizards/summon-all'
```

### Summon Students From House

```
curl --location 'http://localhost:8080/api/wizards/summon-from-house/SLYTHERIN'
```

### View Wands Log

```
curl --location 'http://localhost:8080/api/magical-emporium/wands-log'
```