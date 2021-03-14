package com.javashitang;

import javafx.beans.binding.ObjectExpression;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * @author lilimin
 * @since 2021-03-14
 */
public class ObserverDemo {

    public static void main(String[] args) {
        EventObservable observable = new EventObservable();
        // 添加观察者
        observable.addObserver(new EventObserver());
        // 发布事件
        observable.notifyObservers("hello world");
    }

    static class EventObservable extends Observable {

        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(new EventObject(arg));
            clearChanged();
        }
    }

    static class EventObserver implements Observer, EventListener {

        @Override
        public void update(Observable o, Object arg) {
            EventObject eventObject = (EventObject) arg;
            // 收到事件 java.util.EventObject[source=hello world]
            System.out.println("收到事件 " + eventObject);
        }
    }
}
