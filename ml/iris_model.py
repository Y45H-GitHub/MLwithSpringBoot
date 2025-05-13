# iris_model.py
from sklearn.datasets import load_iris
from sklearn.tree import DecisionTreeClassifier
import pickle

# Load data and train model
iris = load_iris()
X, y = iris.data, iris.target
clf = DecisionTreeClassifier()
clf.fit(X, y)

# Save the model
with open("iris_model.pkl", "wb") as f:
    pickle.dump(clf, f)
