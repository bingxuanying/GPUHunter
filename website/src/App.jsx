import "./App.sass";

function App() {
  return (
    <div className="App">
      <div className="row">gpu bot v1.0</div>
      <div className="row">
        <div className="title">username</div>
        <input className="content-input" type="text" />
      </div>
      <div className="row">
        <div className="title">password</div>
        <input className="content-input" type="password" />
      </div>
      <div className="row">
        <div className="title">refresh rate</div>
        <input className="content-input" type="text" />
      </div>
      <div className="row">
        <div className="title">proxy list</div>
        <input className="content-input" type="text" />
      </div>
      <div className="row">
        <div className="title-input">3060</div>
        <input className="content-input" type="checkbox" checked />
        <div className="title-input">3070</div>
        <input className="content-input" type="checkbox" checked />
        <div className="title-input">3080</div>
        <input className="content-input" type="checkbox" checked />
        <div className="title-input">3090</div>
        <input className="content-input" type="checkbox" checked />
      </div>
      <div className="row">
        <div className="title-input">amz</div>
        <input className="content-input" type="checkbox" checked />
        <div className="title-input">neweggs</div>
        <input className="content-input" type="checkbox" checked />
      </div>
      <div className="row">
        <button>schedule</button>
      </div>
    </div>
  );
}

export default App;
