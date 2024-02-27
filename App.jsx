import React, { useState } from 'react';
import './App.css';

function App() {
  const [showPromptSad, setShowPromptSad] = useState(false);
  const [showPromptHappy, setShowPromptHappy] = useState(false);
  const [showPromptInsecure, setShowPromptInsecure] = useState(false);

  const [promptContent, setPromptContent] = useState('');

  const handleButtonClick = (selectedMood) => {
    switch (selectedMood) {
      case 'sad':
        setPromptContent(
          "It's going to be ok. Everything is just going to be fine. Trust me. It might seem like everything you do is/seems like a mistake, but that's what makes you, you. Everyone makes mistakes sometimes and they still end up fine."
        );
        setShowPromptSad(true);
        setShowPromptHappy(false);
        setShowPromptInsecure(false);
        break;
      case 'happy':
        setPromptContent('Happiness is a wonderful feeling. Enjoy the moment and spread the joy to others!');
        setShowPromptHappy(true);
        setShowPromptSad(false);
        setShowPromptInsecure(false);
        break;
      case 'insecure':
        setPromptContent(
          "Feeling insecure is normal, but remember that you are unique and valuable. Embrace your strengths and be kind to yourself."
        );
        setShowPromptInsecure(true);
        setShowPromptSad(false);
        setShowPromptHappy(false);
        break;
      default:
        setPromptContent('Invalid mood selected.');
        setShowPromptSad(false);
        setShowPromptHappy(false);
        setShowPromptInsecure(false);
        break;
    }
  };

  return (
    <div>
      <p id='main'>How are you feeling</p>
      <p>
        <ul>Everything that is said here is true in every case.</ul>
        <ul>Just remember that you are just human</ul>
        <ul>Take a deep breath</ul>
        <ul>And live</ul>
      </p>

      <div>
        <button onClick={() => handleButtonClick('sad')}>
          Click me if you are sad
        </button>
        {showPromptSad && (
          <div>
            <p>You clicked the button for {"sad"}.</p>
            <p>{promptContent}</p>
            <p>
              <img src='IMG2.png' height={300} width={300}></img>
            </p>
          </div>
        )}
      </div>

      <div>
        <button onClick={() => handleButtonClick('happy')}>
          Click me if you are Happy
        </button>
        {showPromptHappy && (
          <div>
            <p>You clicked the button for {"happy"}.</p>
            <p>{promptContent}</p>
            <p>
            <img src='IMG4.png' height={300} width={300}></img>
            </p>
          </div>
        )}
      </div>

      <div>
        <button onClick={() => handleButtonClick('insecure')}>
          Click me if you are Insecure
        </button>
        {showPromptInsecure && (
          <div>
            <p>You clicked the button for {"insecure"}.</p>
            <p>{promptContent}</p>
            <p>
              <img src='IMG3.png' height={300} width={300}></img>
            </p>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;