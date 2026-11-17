# Laboratorium 3 – drzewa binarne i porządek kopcowy

Dostępne są klasa `Node` (reprezentująca węzeł drzewa binarnego i przechowująca wartość `npl`) oraz funkcja rysująca drzewo do pliku PNG. Pozostałe klasy i funkcje należy napisać samodzielnie.

**Ograniczenie:** w zadaniach nie wolno używać wbudowanych struktur danych Javy (`List`, `ArrayList`, `Map`, `Set`, `Stack`, `Queue` itp.).

## Zadanie 1 – budowanie kopców

Zbuduj trzy kopce typu MAX, wstawiając kolejno wartości od 40 do 1:

- kopiec lewostronny,
- kopiec skośny,
- kopiec NN (bez nazwy) – prosta modyfikacja kopca skośnego, w którym podczas łączenia dwóch kopców przed zwróceniem wyniku **nie dochodzi do zamiany poddrzew** (lewego z prawym).

Uzupełnij funkcję `main` tak, aby budowała kopce i generowała ich rysunki po każdych 10 wstawionych elementach.

Wygenerowane rysunki są pokazane poniżej:

| Kopiec lewostronny | Kopiec skośny | Kopiec NN |
|---|---|---|
| <img src="leftistHeap_10.png" alt="Lewostronny: 10 elementów"> | <img src="skrewHeap_10.png" alt="Skośny: 10 elementów"> | <img src="nnHeap_10.png" alt="NN: 10 elementów"> |
| <img src="leftistHeap_20.png" alt="Lewostronny: 20 elementów"> | <img src="skrewHeap_20.png" alt="Skośny: 20 elementów"> | <img src="nnHeap_20.png" alt="NN: 20 elementów"> |
| <img src="leftistHeap_30.png" alt="Lewostronny: 30 elementów"> | <img src="skrewHeap_30.png" alt="Skośny: 30 elementów"> | <img src="nnHeap_30.png" alt="NN: 30 elementów"> |
| <img src="leftistHeap_40.png" alt="Lewostronny: 40 elementów"> | <img src="skrewHeap_40.png" alt="Skośny: 40 elementów"> | <img src="nnHeap_40.png" alt="NN: 40 elementów"> |


Na podstawie zdobytej wiedzy i wygenerowanych rysunków uzupełnij tabelę złożoności operacji `Union` dla dwóch kopców zawierających łącznie `n` węzłów:

| Rodzaj kopca | Złożoność pesymistyczna | Złożoność zamortyzowana |
|---|---|---|
| Lewostronny |  |  |
| Skośny |  |  |
| NN |  |  |

---

## Zadanie 2 – wysokość kopców

Dla kopców lewostronnego, skośnego i NN zbudowanych w zadaniu 1 wyznacz wysokość drzewa, liczoną w krawędziach od korzenia do najdalszego liścia (liść ma wysokość 0), oraz przygotuj własną listę wszystkich węzłów na największej głębokości.

Dla każdego kopca wypisz jego wysokość i wartości węzłów na największej głębokości. Puste drzewo ma wysokość `-1` i pustą listę.

**Uwaga:** Przygotuj własną jednokierunkową listę, w której można przechowywać węzły drzewa (`Node`) (przechowujemy węzły drzewa, a nie ich wartości).

---

## Zadanie 3 – konwersja kopca skośnego MAX do MIN

Napisz funkcję, która konwertuje kopiec skośny z zadania 2 na kopiec skośny typu MIN (z najmniejszą wartością w korzeniu). Wywołaj ją w `main` i wygeneruj rysunek kopca po konwersji. Wygenerowany rysunek zamieszczono poniżej.

**Uwaga:** nie wolno tworzyć nowych węzłów ani zmieniać wartości istniejących węzłów.

**Uwaga:** pesymistyczna lub zamortyzowana złożoność czasowa napisanej funkcji powinna wynosić `O(n log n)`.

<img src="skewHeap_min_40.png" alt="Kopiec skośny MIN po konwersji 40 elementów" width="100%">
