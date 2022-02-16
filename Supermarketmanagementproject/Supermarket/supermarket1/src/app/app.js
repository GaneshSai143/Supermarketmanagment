app.get('/cors', (req, res) => {
    res.set('Access-Control-Allow-Origin', '*');
    res.send({ "msg": "This has CORS enabled 🎈" })
    })

    const response = await fetch('http://localhost:8080', { mode: 'cors' });