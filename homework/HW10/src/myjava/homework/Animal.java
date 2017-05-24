package myjava.homework;
import java.util.*;
public class Animal <K,T>{
	private K bloodpressure;
	private String id;
	private	String sex;
	private T weight;
	public Animal(K bloodpressure, String id, String sex, T weight){
		this.bloodpressure = bloodpressure;
		this.id = id;
		this.sex = sex;
		this.weight = weight;
	}
	public K get_blood(){
		return this.bloodpressure;
	}
	
	public String get_id(){
		return this.id;
	}
	
	public String get_sex(){
		return this.sex;
	}
	
	public T get_weight(){
		return this.weight;
	}
	@Override
	public int hashCode(){
		return Objects.hash(bloodpressure, id, sex, weight);
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
		final Animal<K, T> other = (Animal<K, T>) obj;
        if (!Objects.equals(this.bloodpressure, other.bloodpressure)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        return true;
    }
	
	@Override
    public String toString()  {
        return String.format("(%s, %s, %s, %s)", id, sex, weight, bloodpressure);
    }
}
