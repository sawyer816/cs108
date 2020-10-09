import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends  StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
          appBar: AppBar(
            title: Text('I DON\u0027T KNOW'),
            backgroundColor: Colors.green,
          ),
          body: Center(
            child: new ButtonBar(
                mainAxisSize: MainAxisSize.min, // this will take space as minimum as posible(to center)
                children: <Widget>[
            new RaisedButton(
            child: new Text('Hello'),
            onPressed: null,
          ),
          new RaisedButton(
            child: new Text('Hi'),
            onPressed: null,
          ),
            new Container(
                color: Colors.blue
            ),
          ]
        )
          ),
          bottomNavigationBar: BottomNavigationBar(
            items: const <BottomNavigationBarItem>[
              BottomNavigationBarItem(
                icon: Icon(Icons.home),
                title: Text('Home'),
              ),
              BottomNavigationBarItem(
                icon: Icon(Icons.business),
                title: Text('Business'),
              ),
              BottomNavigationBarItem(
                icon: Icon(Icons.school),
                title: Text('School'),
              ),
            ],
            currentIndex: 1,
            selectedItemColor: Colors.amber[800],
            onTap: (int index) {}
          ),
        ),
    );

  }
}
