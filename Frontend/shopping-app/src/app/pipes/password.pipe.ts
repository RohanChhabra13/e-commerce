import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'password'
})
export class PasswordPipe implements PipeTransform {

  transform(value: string, character: string = '*'): string {
    // Check if the value is a string
    if (typeof value !== 'string') {
      return value;
    }

    // Replace each character in the value with the specified character
    return value.replace(/./g, character);
  }
}
