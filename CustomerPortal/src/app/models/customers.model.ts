import {Deserializable} from './deserializable.model';

export class Customers implements Deserializable {
public id: number;
public  name: string;
public service: number;

deserialize(input: any): this {
return Object.assign(this, input);
}

}
