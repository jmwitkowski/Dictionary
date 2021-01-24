# dictionary
Dictionary backend aplication - translate sentences.

Aplication to translate sentences and count usage of translated words.

After instaling on host, app expose two endpoints:
*/translate for translation with params - "sentence" and "wordsInQuoteMode"
(eg. http://localhost:8080/translate?sentence=Ala%20ma%20kota&wordsInQuoteMode=false)
*/ranking for gather list of words with their usage count
(eg. http://localhost:8080/ranking)

Enpoints might be testet on swagger ui on */swagger-ui.html
