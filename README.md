# Face and Emotion Recognition
This software recognizes person's faces and their corresponding emotions from a video or webcam feed. Powered by OpenCV, Dlib, face_recognition and Deep Learning.

## Demo
![Image](https://user-images.githubusercontent.com/22372476/47372515-920f0180-d707-11e8-9ba5-d3f51020958a.gif)


## Dependencies
- Opencv
- Dlib
- Keras

## Usage
- Download a `shape_predictor_68_face_landmarks.dat` file from here and put in the folder.
- `test` folder contain images or video that we will feed to the model.
- `images` folder contain only images of person face to perform face recognition.
- `models` contain the pre-trained model for emotion classifier.
- `emotion.py` can to run to classify emotions of person's face.
- `face-rec-emotion.py` can recognise faces and classify emotion at a time.

`python emotion.py`

`python face-rec-emotion.py`

