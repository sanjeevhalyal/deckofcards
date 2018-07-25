# deckofcards
API using java spark.

# Routes

# "/api/deck/new/:shuffle/?deck_count=2"
shuffle can be 
- suffle
- unsuffle
deck_count is number of sets.
deck_count default/minimum will be 1

to get a new shuffled or unshuffled deck.

# "/api/deck/:deck_id/draw/?count=2"

count is number of cards to draw.
count default/minimum will be 1

deck_id is the id of the deck.

to draw card from deck.

# "/api/deck/:deck_id/shuffle/"
deck_id is the id of the deck.

to shuffle a deck

# "/api/deck/new/?deck_count=2"
deck_count is number of sets.
deck_count default/minimum will be 1
to get a new unshuffled deck.
