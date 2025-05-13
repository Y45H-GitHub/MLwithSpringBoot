# app.py
from flask import Flask, request, jsonify
import pickle

app = Flask(__name__)

# Load the saved model
with open("iris_model.pkl", "rb") as f:
    model = pickle.load(f)

@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()
    features = data["features"]  # should be a list of 4 numbers
    prediction = model.predict([features])[0]
    return jsonify({"class": int(prediction)})

import os

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host="0.0.0.0", port=port)
