import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestsofbloodComponent } from './requestsofblood.component';

describe('RequestsofbloodComponent', () => {
  let component: RequestsofbloodComponent;
  let fixture: ComponentFixture<RequestsofbloodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RequestsofbloodComponent]
    });
    fixture = TestBed.createComponent(RequestsofbloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
